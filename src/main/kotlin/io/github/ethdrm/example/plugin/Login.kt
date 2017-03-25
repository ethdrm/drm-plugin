package io.github.ethdrm.example.plugin

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.DialogWrapper.OK_EXIT_CODE
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.ui.layout.CCFlags
import com.intellij.ui.layout.panel
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JTextField

const val LOGIN_COMPONENT_NAME = "login_component"
const val LOGIN_DIALOG_TITLE = "Licence check"
const val PASSWORD = "Password:"
const val USERNAME = "Username:"

class LoginComponent : ApplicationComponent {
    override fun disposeComponent() {
    }

    override fun initComponent() {
        val dialog = LoginDialog()
        dialog.show()
        if (dialog.exitCode == OK_EXIT_CODE) {
            ApplicationManager.getApplication().executeOnPooledThread { LicenceCheck(dialog.credentials, null) }
        }
    }

    override fun getComponentName() = LOGIN_COMPONENT_NAME
}


class LoginDialog : DialogWrapper(null) {
    private val usernameField = JTextField()
    private val passwordField = JPasswordField()

    val credentials : EthCredentials
        get() = EthCredentials(usernameField.text, String(passwordField.password))

    init {
        init()
        title = LOGIN_DIALOG_TITLE
    }

    override fun createCenterPanel(): JPanel = panel {
        row(USERNAME) { usernameField() }
        row(PASSWORD) { passwordField()}
    }

    override fun doValidate() = when {
        credentials.username.isEmpty() -> ValidationInfo("Username field shouldn't be empty", usernameField)
        credentials.password.isEmpty() -> ValidationInfo("Password field should't be empty", passwordField)
        else -> null
    }
}
