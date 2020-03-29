package com.bdd.test.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = { "com.bdd.feature" }, format = { "pretty",
		"html:target/test-outout", "json:target/json_output/cucumber.json",
		"junit:target/junit_xml/cucumber.xml" }, monochrome = true, strict = true)
public class FeatureRunnerTest {
}
