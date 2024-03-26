package com.serra.automation.stepsdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import pages.PracticeFormsPage;

public class PracticeForms {
    PracticeFormsPage practiceFormsPage = new PracticeFormsPage();
    @Given("Navigate to Forms and Practice form")
    public void navigateToFormsAndPracticeForm() {
        practiceFormsPage.choosePracticeForm();
    }

    @When("Fill out {} and {}")
    public void fillOutAnd(String firstName, String lastName) {
        practiceFormsPage.setFirstName(firstName);
        practiceFormsPage.setLastName(lastName);
    }

    @Then("Complete {}")
    public void complete(String email) {
        practiceFormsPage.setEmail(email);
    }

    @When("Choose {}")
    public void choose(String gender) {
        practiceFormsPage.setGender(gender);
    }

    @Then("Add {} and {}")
    public void addAnd(String mobil, String subjects) {
        practiceFormsPage.setMobile(mobil);
        practiceFormsPage.setSubject(subjects);
//        practiceFormsPage.setHobby("Sports");
    }

    @When("fill in {} and {}")
    public void fillInAnd(String address, String state) {
        practiceFormsPage.setCurrentAddress(address);
        practiceFormsPage.setState(state);
    }

    @SneakyThrows
    @Then("Press button Submit")
    public void pressButtonSubmit() {
        practiceFormsPage.submit();
    }
}
