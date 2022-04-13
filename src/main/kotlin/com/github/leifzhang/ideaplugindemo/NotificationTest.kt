package com.github.leifzhang.ideaplugindemo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.Notifications
import com.intellij.openapi.ui.MessageType

class NotificationTest : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val notificationGroup = NotificationGroup("testid", NotificationDisplayType.BALLOON, false)
        val notification = notificationGroup.createNotification("hello world", MessageType.INFO)
        Notifications.Bus.notify(notification)
    }
}