plugins {
    id("java")
}

group = "kat.dev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://storehouse.okaeri.eu/repository/maven-public/")
}

dependencies {
    // JDA
    implementation("net.dv8tion:JDA:5.0.0-beta.24") {
        exclude("org.slf4j", "slf4j-api")
    }

    // Framework
    implementation("com.github.Jsinco:jda-framework:1.5")

    // Logger
    implementation("org.apache.logging.log4j:log4j-core:2.24.1")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.24.1")
    implementation("org.apache.logging.log4j:log4j-api:2.24.1")

    // Going to provide my own guava/gson and okaeri configs for this example.

    // Google guava/gson
    implementation("com.google.guava:guava:33.3.1-jre")
    implementation("com.google.code.gson:gson:2.10.1")

    // Config
    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:5.0.5")
    implementation("eu.okaeri:okaeri-configs-json-gson:5.0.5")

    implementation("io.github.stefanbratanov:jvm-openai:0.11.0")
}
