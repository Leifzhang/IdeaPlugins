package com.github.leifzhang.ideaplugindemo.services

import com.intellij.openapi.project.Project
import com.github.leifzhang.ideaplugindemo.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
