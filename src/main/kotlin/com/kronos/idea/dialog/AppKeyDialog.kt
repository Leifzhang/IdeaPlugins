package com.kronos.idea.dialog

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper

import com.kronos.idea.entity.AppKeyEntity
import com.kronos.idea.entity.getAppKeyList
import com.kronos.idea.utils.FileUtils
import org.jdesktop.swingx.JXComboBox
import java.awt.BorderLayout
import java.io.File
import java.util.*
import javax.swing.*

class AppKeyDialog(val project: Project) : DialogWrapper(true) {

    private var appKeyList: MutableList<AppKeyEntity> = mutableListOf()

    private val rootFile = FileUtils.getRootProjectDir(project)

    private val pro = Properties()
    private val jCheckBox = JXComboBox()

    init {
        rootFile?.getAppKeyList()?.let { appKeyList.addAll(it) }

        loadLocalProperties(rootFile)
        appKeyList.apply {
            add(AppKeyEntity("默认为空", null).apply {

            })
        }
        val moduleAppKey = if (pro.containsKey(KEY)) {
            pro[KEY].toString()
        } else {
            null
        }
        appKeyList.forEach {
            it.isCheck = it.appKey == moduleAppKey
        }
        appKeyList.sortedBy {
            it.isCheck
        }
        init()
    }

    override fun createCenterPanel(): JComponent? {
        val centerPanel = JPanel(BorderLayout())
        appKeyList.forEach {
            jCheckBox.addItem(it.name)
        }
        centerPanel.add(jCheckBox, BorderLayout.PAGE_START)
        return centerPanel
    }

    override fun clickDefaultButton() {
        super.clickDefaultButton()
    }

    override fun createActions(): Array<Action> {
        val exitAction = DialogWrapperExitAction("自定义cancel按钮", CANCEL_EXIT_CODE)
        val okAction = CustomOKAction(this)
        // 设置默认的焦点按钮
        okAction.putValue(DEFAULT_ACTION, true)
        return arrayOf(okAction, exitAction)
    }


    fun saveProperties() {
        val localProFile = File(rootFile, "local.properties")
        localProFile.delete()
        val appkey = appKeyList[jCheckBox.selectedIndex].appKey
        if (appkey.isNullOrEmpty()) {
            pro.remove(KEY)
        } else {
            pro.put(KEY, appkey)
        }
        localProFile.outputStream().use {
            pro.store(it, "")
        }
    }

    private fun loadLocalProperties(rootFile: File?) {
        val localProFile = File(rootFile, "local.properties")
        if (localProFile.exists()) {
            pro.load(localProFile.inputStream())
        }
    }

    companion object {
        const val KEY = "module.app_key"
    }
}