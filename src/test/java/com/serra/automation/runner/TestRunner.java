package com.serra.automation.runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/serra/automation")
@SelectClasspathResource("/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.serra.automation")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty," +  "html:target/cucumber-report/cucumber.html," + "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
@ConfigurationParameter(key = Constants.JUNIT_PLATFORM_NAMING_STRATEGY_PROPERTY_NAME, value = "long")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
public class TestRunner {

}
