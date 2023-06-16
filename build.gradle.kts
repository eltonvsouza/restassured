plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

val cucumberRuntime by configurations.creating {
    extendsFrom(configurations["testImplementation"])
}

repositories {
    mavenCentral()
}

dependencies {
//    testImplementation(platform("org.junit:junit-bom:5.9.1"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-autoconfigure:3.1.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
//    testImplementation("org.junit.platform:junit-platform-suite:1.9.3")
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
//    systemProperty("cucumber.execution.parallel.enabled", "true")
//    systemProperty("cucumber.execution.parallel.config.strategy", "fixed")
//    systemProperty("cucumber.execution.parallel.config.fixed.parallelism", "2")

    useJUnitPlatform()
}
//
//tasks {
//
//    val consoleLauncherTest by registering(JavaExec::class) {
//        dependsOn(testClasses)
//        val reportsDir = file("$buildDir/test-results")
//        outputs.dir(reportsDir)
//        classpath = sourceSets["test"].runtimeClasspath
//        main = "org.junit.platform.console.ConsoleLauncher"
//        args("--scan-classpath")
//        args("--include-engine", "cucumber")
//        args("--reports-dir", reportsDir)
//    }
//
//    test {
////        useJUnitPlatform()
////        systemProperty("cucumber.junit-platform.naming-strategy", "long")
//        dependsOn(consoleLauncherTest)
//        exclude("**/*")
//    }
//}