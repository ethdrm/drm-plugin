package io.github.ethdrm.example.plugin

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

const val LICENCE_CHECK_TASK = "Licence check task"

class LicenceCheck(credentials: EthCredentials, project: Project?) :
        Task.Backgroundable(project, LICENCE_CHECK_TASK, false) {

    override fun run(indicator: ProgressIndicator) =
            try { Thread.sleep(10000) } catch (e : InterruptedException) { e.printStackTrace() }

    override fun onSuccess() {
        super.onSuccess()
        Messages.showMessageDialog(project, "Success", "Success", Messages.getInformationIcon())
    }
}