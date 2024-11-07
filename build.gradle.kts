import kotlin.script.experimental.jvm.util.classpathFromClass

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    repositories{
        google()
        mavenCentral()
    }
    dependencies{
        classpath("com.google.gms:google-services:4.3.4")  // Google Services
        classpath("com.android.tools.build:gradle:8.0.0") // Android Gradle Plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0") // Kotlin Plugin
    }

}
allprojects{
    repositories{
        google()
        mavenCentral()
    }
}


plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}
