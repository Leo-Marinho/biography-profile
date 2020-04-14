package com.biography.profile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = "pretty",
        snippets = CAMELCASE,
        strict = true
)
public class RunnerCucumber extends BiographyProfileEntityApplicationTests {
}
