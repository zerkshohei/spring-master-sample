import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("org.springframework.boot") version "2.2.4.RELEASE" apply false
    application
    kotlin("jvm") version "1.3.71" apply false
    kotlin("plugin.spring") version "1.3.71" apply false
}

allprojects {
    group = "com.zerkshohei"
    repositories {
        jcenter()
    }
}

subprojects {

    apply(plugin = "java")

    dependencies {
        implementation(platform(SpringBootPlugin.BOM_COORDINATES))
        annotationProcessor(platform(SpringBootPlugin.BOM_COORDINATES))
    }

    println("spring boot dependency in root project")

    tasks.withType<Test> {
        useJUnitPlatform()
    }
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}

