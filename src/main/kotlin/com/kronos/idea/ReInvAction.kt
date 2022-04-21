package com.kronos.idea

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import java.io.File


class ReInvAction : AnAction() {

    override fun actionPerformed(ev: AnActionEvent) {
        FileDocumentManager.getInstance().saveAllDocuments()
        VirtualFileManager.getInstance().syncRefresh()
        VirtualFileManager.getInstance().refreshWithoutFileWatcher(true)
        val project = ev.getData(PlatformDataKeys.PROJECT) ?: return
        val apiDir = project.basePath ?: return
        VfsUtil.markDirtyAndRefresh(true, true, true, File(apiDir))
    }

}