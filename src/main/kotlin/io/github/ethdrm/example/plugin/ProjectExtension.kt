package io.github.ethdrm.example.plugin

import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.Messages

fun Project.showError(title: String, message: String?) {
    Messages.showErrorDialog(this, "Error occurred: $message", title)
    ProjectManager.getInstance().reloadProject(this)
}

fun Project.showInfo(title: String, message: String?) {
    Messages.showInfoMessage(this, message, title)
    ProjectManager.getInstance().reloadProject(this)
}

fun Project.notify(title: String, message: String) =
        Notifications.Bus.notify(Notification(title, title, message, NotificationType.INFORMATION))

fun Project.runTask(task: Task.Backgroundable) = ProgressManager.getInstance().run(task)