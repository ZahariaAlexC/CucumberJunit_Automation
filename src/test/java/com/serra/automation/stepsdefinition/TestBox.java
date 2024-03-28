package com.serra.automation.stepsdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TestBoxPage;

public class TestBox {
    TestBoxPage testBoxPage = new TestBoxPage();
    @Given("Navigate to TextBox option")
    public void navigateToTextBoxOption() {
        testBoxPage.navigateToElements();
    }

    @When("I add {} and {}")
    public void iAddAnd(String fullName, String email) {
        testBoxPage.addFullName(fullName);
        testBoxPage.setEmail(email);
    }

    @Then("Add {} press Submit button")
    public void addPressSubmitButton(String currentAddress) {
        testBoxPage.setCurrentAddress(currentAddress);
        testBoxPage.submit();
    }
}
