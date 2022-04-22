package com.kronos.idea.services

import com.intellij.openapi.project.Project
import com.kronos.idea.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
