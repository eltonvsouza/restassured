package org.example.config;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
//@CucumberOptions(
////        features = "src/test/resources",
////        plugin = {"pretty", "html:target/cucumber/bagbasics"},
////        glue = "org/example/steps",
////        extraGlue = "org/example/config"
//)
public class CucumberIntegrationTest {
}