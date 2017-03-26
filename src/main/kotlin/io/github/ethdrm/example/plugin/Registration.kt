package io.github.ethdrm.example.plugin

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.Messages
import org.web3j.crypto.WalletUtils
import java.nio.file.Files
import java.nio.file.Paths

class RegisterTask(project: Project, val walletInfo: WalletInfo) :
        Task.Backgroundable(project, LICENSE_TASK_TITLE, false) {

    override fun run(indicator: ProgressIndicator) {
        WalletUtils.generateLightNewWalletFile(walletInfo.password, walletInfo.file.parentFile)
                .apply { Files.move(Paths.get("${walletInfo.file.parentFile}/$this"), walletInfo.file.toPath()) }
    }

    override fun onSuccess() {
        super.onSuccess()
        Messages.showInfoMessage(project,
                "Your wallet was created in ${walletInfo.file}. Visit our site for following instructions",
                "Wallet created")
        ProjectManager.getInstance().reloadProject(project)
    }

    override fun onThrowable(error: Throwable) {
        Messages.showErrorDialog(project,
                "Error occurred: ${error.message}. Visit our site for following instructions", "Error")
        ProjectManager.getInstance().reloadProject(project)
    }
}