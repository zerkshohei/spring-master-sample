plugins {
    java
    id("org.openapi.generator").version("4.2.1")
}

dependencies {
}


// TODO: 外部変数化, output-pathの変更
openApiGenerate {
    generatorName.set("kotlin-spring");
    inputSpec.set("${projectDir}/spec/openapi.yml")
}

openApiValidate { inputSpec.set("${projectDir}/spec/openapi.yml") }

