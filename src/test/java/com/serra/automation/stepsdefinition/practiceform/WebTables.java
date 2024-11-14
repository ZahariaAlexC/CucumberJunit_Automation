package com.serra.automation.stepsdefinition.practiceform;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.practiceform.WebTablePage;

public class WebTables {
    WebTablePage webTablePage;

    public WebTables() {
        this.webTablePage = new WebTablePage();
    }

    @Given("Navigate to weTable")
    public void navigateToWeTable() {
        webTablePage.navigateToElements();
    }

    @When("Registration a person {} and {}")
    public void registrationAPersonAnd(String name, String number) {
        webTablePage.registrationPerson(name, name, name,number, number, name);
    }

    @Then("press Submit button")
    public void pressSubmitButton() {
        webTablePage.submitBtn();
    }

    @When("Check if the person is in the table")
    public void checkIfThePersonIsInTheTable() {
        Assertions.assertTrue(webTablePage.checkTable());
    }

    @Then("Delete current person and check it")
    public void deleteCurrentPersonAndCheckIt() {
        Assertions.assertTrue(webTablePage.deleteItemAndCheck());
    }
}
