package io.github.ethdrm.example.plugin

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import io.guthub.ethdrm.example.plugin.contract.Drm
import org.web3j.abi.datatypes.Address
import org.web3j.abi.datatypes.generated.Uint256
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Web3j
import org.web3j.protocol.infura.InfuraHttpService
import org.web3j.tx.Contract
import org.web3j.tx.ManagedTransaction
import rx.Observable
import java.math.BigInteger
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

const val LICENSE_TASK_TITLE = "License validation"

class RegisterTask(project: Project, val walletInfo: WalletInfo) : Task.Backgroundable(project, LICENSE_TASK_TITLE) {

    private var address: String? = null

    override fun run(indicator: ProgressIndicator) {
        WalletUtils.generateLightNewWalletFile(walletInfo.password, walletInfo.file.parentFile)
                .apply { Files.move(Paths.get("${walletInfo.file.parentFile}/$this"), walletInfo.file.toPath()) }
        address = WalletUtils.loadCredentials(walletInfo.password, walletInfo.file).address
    }

    override fun onSuccess() =
            project.showInfo(LICENSE_TASK_TITLE, "Wallet created at ${walletInfo.file}. Your address: $address")

    override fun onThrowable(error: Throwable) = project.showError(LICENSE_TASK_TITLE, error.message)
}


class SignInTask(project: Project, val walletInfo: WalletInfo) : Task.Backgroundable(project, LICENSE_TASK_TITLE) {

    private var hasLicense = false

    private val properties = Properties().apply {
        SignInTask::class.java.getResourceAsStream("/application.properties").use { load(it) }
    }

    override fun run(indicator: ProgressIndicator) {
        val credentials = WalletUtils.loadCredentials(walletInfo.password, walletInfo.file)
        val web3j = Web3j.build(InfuraHttpService(properties.getProperty(INFURA_URL)))
        val drm = Drm.load(properties.getProperty(DRM_ADDRESS), web3j, credentials,
                ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT)

        Observable.from(drm.check(Address(credentials.address), Uint256(BigInteger.ONE)))
                .map { drm.getHasLicenceEvents(it) }
                .isEmpty
                .toBlocking()
                .subscribe { hasLicense = !it }
    }

    override fun onSuccess() = when {
        hasLicense -> project.notify(LICENSE_TASK_TITLE, "License verified. Enjoy!")
        else -> project.showError(LICENSE_TASK_TITLE, "Your license is invalid.")
    }

    override fun onThrowable(error: Throwable) = project.showError(LICENSE_TASK_TITLE, error.message)

    companion object {
        const val INFURA_URL = "infura.url"
        const val DRM_ADDRESS = "drm.address"
    }
}