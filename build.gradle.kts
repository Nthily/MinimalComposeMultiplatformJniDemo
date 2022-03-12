import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0"
}

group = "com.github.nthily"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
}

task("cargoBuild") {
    doLast {
        exec {
            workingDir = File(project.projectDir, "src/main/rust")
            commandLine = listOf("cmd", "/c", "build.sh")
        }
    }
}

tasks.matching { it.name == "compileKotlin" }.all {
    dependsOn("cargoBuild")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "com.github.nthily.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "MinimalComposeMultiplatformJniDemo"
            packageVersion = "1.0.0"
        }
    }
}