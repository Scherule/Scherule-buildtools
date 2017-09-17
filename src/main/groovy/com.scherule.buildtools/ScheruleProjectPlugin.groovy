package com.scherule.buildtools

import groovy.json.JsonSlurper
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.wrapper.Wrapper

class ScheruleProjectPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        mountExtensions(project)
        versionProject(project)

        addWrapperTask(project)

        project.afterEvaluate {
            println "Project version: ${project.extensions.version}"
        }
    }

    def static mountExtensions(Project project) {
        project.extensions.add("scheruleProject", ScheruleProjectExtension)
    }

    def static versionProject(Project project) {
        project.configure(project) {

            def semanticVersion = new JsonSlurper().parseText(
                    new File("${project.projectDir}/version.json").text
            )

            project.extensions.version = new ScheruleProjectVersion(
                    major: semanticVersion['major'],
                    minor: semanticVersion['minor'],
                    patch: semanticVersion['patch'],
            )

        }
    }

    def static addWrapperTask(Project project) {
        project.task('wrapper', type: Wrapper) {
            gradleVersion = '4.0'
        }
    }

}
