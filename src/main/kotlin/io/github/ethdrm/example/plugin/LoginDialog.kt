package io.github.ethdrm.example.plugin

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.ui.layout.panel
import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.Action
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JTextField

class LoginDialog(project: Project) : DialogWrapper(project) {

    private val usernameField = JTextField(DEFAULT_COLUMN_WIDTH)
    private val passwordField = JPasswordField(DEFAULT_COLUMN_WIDTH)

    val walletInfo: WalletInfo
        get() = WalletInfo(usernameField.text, String(passwordField.password))

    init {
        init()
        title = LOGIN_DIALOG_TITLE
    }

    override fun createActions(): Array<out Action> =
            arrayOf(ValidatedAction(SIGN_IN, SIGN_IN_CODE), ValidatedAction(REGISTER, REGISTER_CODE))

    override fun createCenterPanel(): JPanel = panel {
        row(USERNAME) { usernameField() }
        row(PASSWORD) { passwordField()}
    }

    override fun doValidate() = when {
        walletInfo.title.isEmpty() -> ValidationInfo("Username field shouldn't be empty", usernameField)
        walletInfo.password.isEmpty() -> ValidationInfo("Password field should't be empty", passwordField)
        else -> null
    }

    override fun shouldCloseOnCross() = false

    companion object {
        const val LOGIN_DIALOG_TITLE = "License validation"
        const val DEFAULT_COLUMN_WIDTH = 20
        const val SIGN_IN_CODE = 100
        const val REGISTER_CODE = 200
        const val SIGN_IN = "Sign In"
        const val REGISTER = "Register"
        const val PASSWORD = "Password:"
        const val USERNAME = "Username:"
    }

    fun ValidatedAction(name: String, code: Int) = object: AbstractAction(name) {
        override fun actionPerformed(e: ActionEvent?) = if (doValidate() != null) initValidation() else close(code)
    }
}