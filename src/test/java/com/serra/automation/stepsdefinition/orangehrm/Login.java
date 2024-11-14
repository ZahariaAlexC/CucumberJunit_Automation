package com.serra.automation.stepsdefinition.orangehrm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.orangehrm.LoginPage;

import static base.Constants.ORANGE_HRM_URL;

public class Login {
    private final LoginPage loginPage;
    public Login(){
        loginPage =  new LoginPage();
    }
    @Given("Navigate to OrangeHRM")
    public void navigateToOrangeHRM() {
        loginPage.getDriver().get(ORANGE_HRM_URL);
    }

    @When("Fill in {}")
    public void fillIn(String username) {
        loginPage.addUsername(username);
    }
    @Then("Add {}")
    public void add(String password) {
        loginPage.addPassword(password);
    }

    @Then("Press Login button")
    public void pressLoginButton() {
        loginPage.pressLogin();
    }
}
