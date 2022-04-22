package com.kronos.idea

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.kronos.idea.dialog.AppKeyDialog


class AppkeyAction : AnAction() {

    override fun actionPerformed(ev: AnActionEvent) {
        val project = ev.getData(PlatformDataKeys.PROJECT) ?: return


        //  val mFile: PsiFile? = PsiUtilBase.getPsiFileInEditor(editor, project)
        AppKeyDialog(project).showAndGet()
    }


}