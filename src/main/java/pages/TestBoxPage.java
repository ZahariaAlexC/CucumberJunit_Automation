package pages;

import base.BasePage;
import com.mongodb.binding.WriteBinding;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestBoxPage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Full Name']")
    private WebElement fullName;
    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    private WebElement email;
    @FindBy(xpath = "//textarea[@placeholder='Current Address']")
    private WebElement currentAddress;
    @FindBy(xpath = "//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[1]/span[1]/div[1]")
    private WebElement elementsOption;
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-0']")
    private WebElement textBoxOption;
    @FindBy(xpath = "//div[@class='category-cards']//div[2]//div[1][normalize-space() = 'Forms']")
    private WebElement form;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitBtn;



    public void navigateToElements(){
        moveToElement();
        click(form);
        click(elementsOption);
        waitPage().until(ExpectedConditions.visibilityOf(textBoxOption));
        click(textBoxOption);
        moveToElement();
    }

    public void addFullName(String name){
        waitPage().until(ExpectedConditions.visibilityOf(fullName));
        addText(name, fullName);
    }

    public void setEmail(String email){
        addText(email, this.email);
    }

    public void setCurrentAddress(String address){
        addText(address, currentAddress);
    }

    public void submit(){
        click(submitBtn);
    }
}
