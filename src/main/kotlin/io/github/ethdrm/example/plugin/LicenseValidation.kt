package io.github.ethdrm.example.plugin

import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.actionSystem.PopupAction
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.Messages
import io.guthub.ethdrm.example.plugin.contract.Drm
import org.web3j.abi.datatypes.Address
import org.web3j.abi.datatypes.generated.Uint256
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Web3j
import org.web3j.protocol.infura.InfuraHttpService
import org.web3j.tx.Contract.GAS_LIMIT
import org.web3j.tx.ManagedTransaction.GAS_PRICE
import rx.Observable
import java.math.BigInteger
import java.util.*

const val LICENSE_TASK_TITLE = "License validation"

class LicenseTask(project: Project, val walletInfo: WalletInfo) :
        Task.Backgroundable(project, LICENSE_TASK_TITLE, false) {

    val properties = Properties().apply {
        LicenseTask::class.java.getResourceAsStream("/application.properties").use { load(it) }
    }

    var result = false

    override fun run(indicator: ProgressIndicator) {
        val credentials = WalletUtils.loadCredentials(walletInfo.password, walletInfo.file)
        val web3j = Web3j.build(InfuraHttpService(properties.getProperty(INFURA_URL)))
        val drm = Drm.load(properties.getProperty(DRM_ADDRESS), web3j, credentials, GAS_PRICE, GAS_LIMIT)

        Observable.from(drm.check(Address(credentials.address), Uint256(BigInteger.ONE)))
                .map { drm.getHasLicenceEvents(it) }
                .isEmpty
                .toBlocking()
                .subscribe { result = !it }
    }

    override fun onSuccess() {
        super.onSuccess()
        if (!result) {
            Messages.showErrorDialog(project, "Sorry, but you don't have the license. Visit our site to buy one",
                    "License validation error")
            ProjectManager.getInstance().reloadProject(project)
        } else {
            Notifications.Bus.notify(Notification(LICENSE_TASK_TITLE, LICENSE_TASK_TITLE,
                    "License validation success", NotificationType.INFORMATION))
        }
    }

    override fun onThrowable(error: Throwable) {
        Messages.showErrorDialog(project, "Error occured: ${error.message}", "License validation error")
        ProjectManager.getInstance().reloadProject(project)
    }

    companion object {
        const val INFURA_URL = "infura.url"
        const val DRM_ADDRESS = "drm.address"
    }
}
