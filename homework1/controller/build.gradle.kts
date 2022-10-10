plugins {
    id("java")
    id("org.flywaydb.flyway") version "9.4.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation(project(":models"))
    implementation("com.intellij:annotations:12.0")
    implementation("org.postgresql:postgresql:42.5.0")
    implementation("com.google.code.gson:gson:2.9.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

flyway {
    driver = "org.postgresql.Driver"
    url = "jdbc:postgresql://localhost:5432/homework1"
    user = "postgres"
    password = "root"
    schemas = arrayOf("public")
    defaultSchema = "public"
}