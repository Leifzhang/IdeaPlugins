package com.kronos.idea

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.kronos.idea.dialog.TestDialog
import com.kronos.idea.entity.AppKeyEntity
import com.kronos.idea.entity.getAppKeyList
import com.kronos.idea.utils.FileUtils
import java.io.File
import java.util.Properties


class AppkeyAction : AnAction() {

    override fun actionPerformed(ev: AnActionEvent) {
        val project = ev.getData(PlatformDataKeys.PROJECT) ?: return


        //  val mFile: PsiFile? = PsiUtilBase.getPsiFileInEditor(editor, project)
        TestDialog(project).showAndGet()
    }


}