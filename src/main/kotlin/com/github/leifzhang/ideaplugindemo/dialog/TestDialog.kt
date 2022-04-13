package com.github.leifzhang.ideaplugindemo.dialog

import com.intellij.openapi.ui.DialogWrapper
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

class TestDialog() : DialogWrapper(true) {

    init {
        init()
    }

    override fun createCenterPanel(): JComponent? {
        val centerPanel = JPanel(BorderLayout())
        val label = JLabel("hello world")
        label.preferredSize = Dimension(100, 100)
        centerPanel.add(label, BorderLayout.CENTER)
        return centerPanel
    }
}