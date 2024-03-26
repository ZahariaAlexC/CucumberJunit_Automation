package com.serra.automation.stepsdefinition;

import base.CreateDriverInstance;
import io.cucumber.java.*;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;
    @Before
    public void start(){
        driver = CreateDriverInstance.driverInstanceChrome();
    }

    @After
    public void close(){
        driver.quit();
    }
}
