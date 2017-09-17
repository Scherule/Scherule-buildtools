package com.scherule.buildtools


class ScheruleProjectVersion {

    String major = 1
    String minor = 0
    String patch = 0
    String build = false

    @Override
    String toString() {
        String fullVersion = "$major.$minor.$patch"
        if (build) {
            fullVersion += ".$build"
        }
        fullVersion
    }

}
