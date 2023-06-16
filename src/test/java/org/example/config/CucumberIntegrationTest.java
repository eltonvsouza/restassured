package org.example.config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources"
//        plugin = {"pretty", "html:target/cucumber/bagbasics"},
//        glue = "org/example/steps",
//        extraGlue = "org/example/config"
)
public class CucumberIntegrationTest {
}