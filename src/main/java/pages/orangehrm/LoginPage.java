package pages.orangehrm;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement loginButton;


    public void addUsername(String username){
        waitPage().until(ExpectedConditions.visibilityOf(this.username));
        addText(username,this.username);
    }

    public void addPassword(String password){
        addText(password, this.password);
    }

    public void pressLogin(){
        click(loginButton);
    }
}
