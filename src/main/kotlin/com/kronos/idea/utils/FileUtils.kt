package com.kronos.idea.utils

import java.io.File

import com.intellij.openapi.project.Project

/**
 *
 *  @Author LiABao
 *  @Since 2022/2/10
 *
 */
object FileUtils {

    fun File?.getGradleVersionFile(): File? {
        if (this == null) {
            return null
        }
        val file = File(this, "plugins.gradle")
        if (file.exists()) {
            return file
        }
        return null
    }


    private fun getRootFile(project: Project): File? {
        return project.projectFilePath?.let {
            File(it)
        }
    }

    fun getRootProjectDir(project: Project): File? {
        var f = getRootFile(project)
        var root: File? = null
        while (f != null) {
            if (File(f, "settings.gradle").exists()) {
                root = f
            }
            f = f.parentFile
        }
        return root
    }
}