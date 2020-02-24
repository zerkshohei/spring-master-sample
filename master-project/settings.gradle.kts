pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/plugins-release") }
        gradlePluginPortal()
        mavenCentral()
    }
}
rootProject.name = "master-project"
includeFlat("initial");

// TODO: 別プロジェクト化できる。
// マイグレーションツールと、doma自動生成処理は別プロジェクトにして自動生成成果物のみmainプロジェクトで使用する。
includeFlat("doma-flyway");
includeFlat("openapi-gen");
