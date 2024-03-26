package com.serra.automation.stepsdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

public class Login {
    LoginPage loginPage = new LoginPage();
    String username;
    String password;

    @Given("Fill in {} and {}")
    public void fillInAnd(String username, String password) {
        this.username = username;
        this.password = password;
        loginPage.setUsernameBox(username);
        loginPage.setPasswordBox(password);
    }

    @Then("press Login button")
    public void pressLoginButton() {
        loginPage.clickOnLoginButton();
        loginPage.setUsernameBox(this.username);
        loginPage.setPasswordBox(this.password);
        loginPage.clickOnLoginButton();
        Assertions.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
                loginPage.getDashboardURL(), "Utilizatorul nu s-a logat cu succes");
    }
}
