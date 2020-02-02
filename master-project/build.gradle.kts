import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("org.springframework.boot") version "2.2.4.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
//    id("io.spring.gradle.propdeps-plugin") version "0.0.9.RELEASE"
    kotlin("jvm") version "1.3.60"
    kotlin("plugin.spring") version "1.3.60" apply false
}

allprojects {
    group = "com.zerkshohei"
    repositories { mavenCentral() }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
//    apply(plugin = "java")
//    apply(plugin = "java-library")
//    apply plugin: 'java'
//    apply plugin: 'java-library'
//    apply plugin: 'eclipse'
//    apply plugin: 'idea'
//    apply plugin: 'io.spring.dependency-management'
//    apply(plugin = "propdeps")
//    apply(plugin = "propdeps-maven")
//    apply(plugin = "propdeps-idea")
//    apply(plugin = "propdeps-eclipse")

    val developmentOnly: Configuration by configurations.creating
    configurations {
        runtimeClasspath {
            extendsFrom(developmentOnly)
        }
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    dependencyManagement {
        imports {
            mavenBom(SpringBootPlugin.BOM_COORDINATES)
        }
    }

    println("spring boot dependency in root project")

    // 混在する場合は必要になるはず
//    java.sourceCompatibility = JavaVersion.VERSION_11
//    java.targetCompatibility = JavaVersion.VERSION_11

    tasks {
        withType<Test> {
            useJUnitPlatform()
        }
        withType<KotlinCompile>().configureEach {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "1.8"
            }
        }
    }
}

