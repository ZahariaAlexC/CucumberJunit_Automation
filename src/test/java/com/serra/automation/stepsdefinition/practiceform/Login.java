package com.serra.automation.stepsdefinition.practiceform;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.practiceform.LoginPage;

public class Login {
    LoginPage loginPage;
    String username;
    String password;

    public Login() {
        this.loginPage = new LoginPage();
    }

    @Given("Fill in {} and {}")
    public void fillInAnd(String username, String password) {
        this.username = username;
        this.password = password;
        loginPage.setUsernameBox(username);
        loginPage.setPasswordBox(password);
    }

    @Then("press com.serra.automation.stepsdefinition.orangehrm.Login button")
    public void pressLoginButton() {
        loginPage.clickOnLoginButton();
        loginPage.setUsernameBox(this.username);
        loginPage.setPasswordBox(this.password);
        loginPage.clickOnLoginButton();
        Assertions.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
                loginPage.getDashboardURL(), "Utilizatorul nu s-a logat cu succes");
    }
}
