package com.scherule.buildtools


public class ScheruleProjectVersion {

    String major = 1
    String minor = 0
    String patch = 0
    String build

    @Override
    String toString() {
        String fullVersion = "$major.$minor.$patch"
        if (build) {
            fullVersion += ".$build"
        }
        fullVersion
    }

}
