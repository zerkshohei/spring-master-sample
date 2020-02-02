pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/plugins-release") }
        gradlePluginPortal()
        mavenCentral()
    }
}
rootProject.name = "master-project"
includeFlat("initial");
