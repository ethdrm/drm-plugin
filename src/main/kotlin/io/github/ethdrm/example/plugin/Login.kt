package io.github.ethdrm.example.plugin

import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.project.Project
import io.github.ethdrm.example.plugin.LoginDialog.Companion.REGISTER_CODE
import io.github.ethdrm.example.plugin.LoginDialog.Companion.SIGN_IN_CODE
import java.io.File

class LoginComponent(val project: Project) : ProjectComponent {

    override fun disposeComponent() {}

    override fun initComponent() {}

    override fun projectClosed() {}

    override fun projectOpened() = with(LoginDialog(project)) {
        show()
        when (exitCode) {
            SIGN_IN_CODE -> project.runTask(SignInTask(project, walletInfo))
            REGISTER_CODE -> project.runTask(RegisterTask(project, walletInfo))
        }
    }

    override fun getComponentName() = LOGIN_COMPONENT_NAME

    companion object {
        const val LOGIN_COMPONENT_NAME = "login_component"
    }
}


data class WalletInfo(val title: String, val password: String) {

    val file = File("${System.getProperty(USER_HOME)}/$DRM_DIR/$title").apply { parentFile.mkdirs() }

    companion object {
        const val USER_HOME = "user.home"
        const val DRM_DIR = ".ethdrm"
    }
}