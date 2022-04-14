package com.kronos.idea.entity

import org.yaml.snakeyaml.Yaml
import java.io.File

data class AppKeyEntity(
    val name: String?, val appKey: String?
) {
    var isCheck = false
}

fun File.getAppKeyList(): MutableList<AppKeyEntity> {
    val keyFile = File(this, "appkey.yaml")
    val appKeyList = mutableListOf<AppKeyEntity>()
    if (exists()) {
        try {
            val yaml = Yaml()
            val modules = yaml.load<HashMap<String, Any>>(keyFile.inputStream())
            val apps = modules["apps"] as ArrayList<HashMap<String, String>>
            apps.forEach { info ->
                if (info["appkey"].isNullOrEmpty() || info["name"].isNullOrEmpty()) {
                    throw  RuntimeException("appkey.yaml is error yaml: $info")
                }
                appKeyList.add(AppKeyEntity(info["name"] ?: "", info["appkey"] ?: ""))
            }
        } catch (throwable: Throwable) {
            // Logger.log("maven.yaml invalid yaml : " + this.absolutePath)
        }
    } else {
        //   Logger.log("maven.yaml not exists module path:${this.parent}")
    }
    return appKeyList
}