package io.github.ethdrm.example.plugin

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.DialogWrapper.OK_EXIT_CODE
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.ui.layout.CCFlags
import com.intellij.ui.layout.panel
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import java.io.File
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JTextField

const val LOGIN_COMPONENT_NAME = "login_component"
const val LOGIN_DIALOG_TITLE = "License validation"

class LoginComponent(val project: Project) : ProjectComponent {
    override fun disposeComponent() {}

    override fun initComponent() {}

    override fun projectClosed() {}

    override fun projectOpened() {
        val dialog = LoginDialog(project)
        dialog.show()

        if (dialog.exitCode == OK_EXIT_CODE) {
            ProgressManager.getInstance().run(LicenseTask(project, dialog.walletInfo))
        }
    }

    override fun getComponentName() = LOGIN_COMPONENT_NAME
}


class LoginDialog(project: Project) : DialogWrapper(project) {
    private val usernameField = JTextField()
    private val passwordField = JPasswordField()

    val walletInfo by lazy { WalletInfo(usernameField.text, String(passwordField.password)) }

    init {
        init()
        title = LOGIN_DIALOG_TITLE
    }

    override fun createCenterPanel(): JPanel = panel {
        row(USERNAME) { usernameField() }
        row(PASSWORD) { passwordField()}
    }

    override fun doValidate() = when {
        walletInfo.title.isEmpty() -> ValidationInfo("Username field shouldn't be empty", usernameField)
        walletInfo.password.isEmpty() -> ValidationInfo("Password field should't be empty", passwordField)
        else -> null
    }

    companion object {
        const val PASSWORD = "Password:"
        const val USERNAME = "Username:"
    }
}


class WalletInfo(val title: String, val password: String) {
    val file = File("${System.getProperty(USER_HOME)}/$DRM_DIR/$title")

    companion object {
        const val USER_HOME = "user.home"
        const val DRM_DIR = ".ethdrm"
    }
}