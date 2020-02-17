plugins {
    application
    id("org.flywaydb.flyway").version("6.2.3")
}

repositories {
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
}
// TODO: verion系を外部変数化する。

dependencies {
    implementation("org.postgresql:postgresql:42.2.8")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.seasar.doma:doma-gen:2.27.1")
}

// TODO: 外部変数化
flyway {
    url = "jdbc:postgresql://localhost:5432/postgres"
    user = "postgres"
    password = "psexample"
}
