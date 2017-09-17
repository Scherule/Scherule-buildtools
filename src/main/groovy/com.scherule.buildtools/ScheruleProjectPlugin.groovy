package com.scherule.buildtools

import org.gradle.api.Plugin
import org.gradle.api.Project


class ScheruleProjectPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.add("scherule-project", ScheruleProjectExtension)
    }

}
