// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.3")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.40.5")

        // NOTE: Do not place your application dependencies here; they belong

    }
}

tasks.register("clean", Delete::class) {
    delete (rootProject.buildDir)
}