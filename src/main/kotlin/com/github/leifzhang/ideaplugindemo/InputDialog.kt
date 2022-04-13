package com.github.leifzhang.ideaplugindemo

import com.github.leifzhang.ideaplugindemo.dialog.TestDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiUtilBase


class InputDialog : AnAction() {

    override fun actionPerformed(ev: AnActionEvent) {
        val project = ev.getData(PlatformDataKeys.PROJECT) ?: return
        //  val mFile: PsiFile? = PsiUtilBase.getPsiFileInEditor(editor, project)
        TestDialog().showAndGet()
    }
}