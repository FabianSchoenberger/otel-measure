import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform") version "2.1.10"
}

group = "com.infendro.otel.measure"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    jvm {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        mainRun {
            mainClass.set("MainKt")
        }
    }
    js {
        nodejs()
        useCommonJs()
        binaries.executable()
    }
    linuxX64 {
        binaries.executable {
            entryPoint = "main"
        }
    }
}
