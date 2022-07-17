package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepdefs", "com"},
        features = {"src/test/resources/features/"},
        plugin = {"json:target/cucumber/cucumber.json",
                "html:target/cucumber-report/cucumber.html",
                "junit:target/cucumber/cucumber.xml"},
        tags = " @test")

public class CucumberRunner {
}
