plugins {
    id("java")
    application
}

group = "at.ac.tgm.fseemann"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("at.ac.tgm.fseemann.worttrainer.Main")
}

tasks.test {
    useJUnitPlatform()
}