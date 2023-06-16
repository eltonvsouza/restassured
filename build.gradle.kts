plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

//val cucumberRuntime by configurations.creating {
//    extendsFrom(configurations["testImplementation"])
//}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-autoconfigure:3.1.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
    testImplementation("io.cucumber:cucumber-junit:7.12.1")
    testImplementation("io.cucumber:cucumber-core:7.12.1")
    testImplementation("io.cucumber:cucumber-java8:7.12.1")
    testImplementation("io.cucumber:cucumber-java:7.12.1")
    testImplementation("io.cucumber:cucumber-jvm:7.12.1")
    testImplementation("io.cucumber:cucumber-spring:7.12.1")
    testImplementation("io.cucumber:gherkin:26.2.0")
    testImplementation("io.cucumber:datatable:7.12.1")
    testImplementation("io.cucumber:datatable-matchers:7.12.1")
    testImplementation("io.rest-assured:rest-assured:5.3.0")

}

tasks.test {
    useJUnitPlatform()
}
