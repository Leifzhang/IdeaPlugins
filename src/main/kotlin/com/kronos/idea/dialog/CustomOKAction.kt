package com.kronos.idea.dialog

import com.intellij.openapi.ui.DialogWrapper.CLOSE_EXIT_CODE
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

class CustomOKAction(val dialog: TestDialog) : AbstractAction("自定义ok按钮") {
    override fun actionPerformed(e: ActionEvent?) {
        dialog.saveProperties()
        dialog.close(CLOSE_EXIT_CODE)
    }


}