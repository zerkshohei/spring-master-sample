import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("org.springframework.boot") version "2.2.4.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.9.RELEASE" apply false
    kotlin("jvm") version "1.3.60" apply false
    kotlin("plugin.spring") version "1.3.60" apply false
}

allprojects {
    group = "com.zerkshohei"
    repositories {
        jcenter()
    }
}

subprojects {

    apply(plugin = "io.spring.dependency-management")
    the<DependencyManagementExtension>().apply {
        imports {
            mavenBom(SpringBootPlugin.BOM_COORDINATES)
        }
    }

    println("spring boot dependency in root project")

    // 混在する場合は必要になるはず
//    java.sourceCompatibility = JavaVersion.VERSION_11
//    java.targetCompatibility = JavaVersion.VERSION_11

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

