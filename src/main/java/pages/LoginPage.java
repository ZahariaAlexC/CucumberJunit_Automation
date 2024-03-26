package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public void setUsernameBox(String username){
        waitPage().until(ExpectedConditions.visibilityOf(this.usernameBox));
        addText(username,this.usernameBox);
    }

    public void setPasswordBox(String password) {
        addText(password,this.passwordBox);
    }
    public void clickOnLoginButton(){
        click(loginButton);
    }

    public String getDashboardURL(){
        return getUrl();
    }
}
