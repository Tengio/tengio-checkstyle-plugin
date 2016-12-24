package com.tengio.gradle

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.plugins.quality.CheckstylePlugin
import org.gradle.api.plugins.quality.Checkstyle
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.nio.file.Paths

class TengioCheckstylePlugin implements Plugin<Project> {

    final Logger log = LoggerFactory.getLogger('TengioCheckstylePlugin')

    void apply(Project project) {
        log.debug("Applying TengioCheckstylePlugin to " + project)
        project.extensions.create("tengioCheckstyle", TengioCheckstylePluginExtension)
        project.plugins.withType(CheckstylePlugin) {
            project.checkstyle {
                toolVersion = "7.3"
                config = project.resources.text.fromString(getClass().getResourceAsStream("checkstyle.xml").text)
            }
        }
        project.pluginManager.apply('checkstyle')
        if(!project.pluginManager.hasPlugin('checkstyle')) {
            throw new RuntimeException("Didn't apply checkstyle plugin");  
        }
        if(!hasTask(project, 'checkstyleMain')) {
            log.debug("Adding checkstyle manually as source set are probably not define for android")
            Checkstyle t = project.tasks.create('checkstyleMain', Checkstyle)
            t.source = 'src'
            t.include '**/*.java'
            t.exclude '**/gen/**'
            t.classpath = project.files()
            // t.toolVersion = "7.3" can set version from task
            t.config = project.resources.text.fromString(getClass().getResourceAsStream("checkstyle.xml").text)
            log.debug("Attacking task to check")
            project.tasks.getByName('check').dependsOn 'checkstyleMain'
        }
        log.debug(project.tasks.toString())
    }

    def boolean hasTask(Project project, String taskName) {
        try {
            project.tasks.getByName(taskName)
            return true
        } catch(Exception e) {
            return false
        }
    }
}

class TengioCheckstylePluginExtension {
    // for now not used
}