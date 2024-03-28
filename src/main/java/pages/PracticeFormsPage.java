package pages;

import base.BasePage;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PracticeFormsPage extends BasePage {
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement email;
    @FindBy(xpath = "//div[@class= 'custom-control custom-radio custom-control-inline']//label[normalize-space() = 'Male']")
    private WebElement genderMale;
    @FindBy(xpath = "//div[@class= 'custom-control custom-radio custom-control-inline']//label[normalize-space() = 'Female']")
    private WebElement genderFemale;
    @FindBy(xpath = "//div[@class= 'custom-control custom-radio custom-control-inline']//label[normalize-space() = 'Other']")
    private WebElement genderOther;
    @FindBy(xpath = " //input[@placeholder='Mobile Number']")
    private WebElement mobile;
    @FindBy(xpath = "//div[@class = 'subjects-auto-complete__input']//input")
    private WebElement subject;
    @FindBy(xpath = "//div[@class = 'subjects-auto-complete__menu css-26l3qy-menu']//div")
    private List<WebElement> listOfSubjects;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement hobbySport;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement hobbyReading;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement hobbyMusic;
    @FindBy(xpath = "(//div[@class=' css-1wa3eu0-placeholder'])[1]")
    private WebElement state;
    @FindBy(xpath = "//div[@id='state']//div[@class=' css-1hwfws3']//input")
    private WebElement stateInput;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddress;
    @FindBy(xpath = "//div[@class=' css-26l3qy-menu']//div//div")
    private List<WebElement> listOfStates;
    @FindBy(xpath = "//button[@id= 'submit']")
    private WebElement submit;
    @FindBy(xpath = "//div[@class='category-cards']//div[2]//div[1][normalize-space() = 'Forms']")
    private WebElement form;
    @FindBy(xpath = "//div[@class='element-list collapse show']")
    private WebElement practiceFormMenu;


    public void choosePracticeForm(){
        waitPage().until(ExpectedConditions.visibilityOf(form));
        moveToElement();
        click(form);
        click(practiceFormMenu);
        moveToElement();
    }

    public void setFirstName(String firstName){
        waitPage().until(ExpectedConditions.visibilityOf(this.firstName));
        addText(firstName, this.firstName);
    }

    public void setLastName(String lastName){
        addText(lastName, this.lastName);
    }

    public void setEmail(String email){
        addText(email, this.email);
    }

    public void setGender(String gender) {
        switch (gender) {
            case "Male" -> click(genderMale);
            case "Female" -> click(genderFemale);
            case "Other" -> click(genderOther);
            default -> {
                try {
                    throw new Exception("No argument availables");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void setMobile(String mobile){
        addText(mobile, this.mobile);
    }

    public void setSubject(String subject){
        addText(subject,this.subject);
        this.subject.sendKeys(Keys.ENTER);
    }

    public void setHobby(String hobby) {
        switch (hobby) {
            case "Sports" -> click(hobbySport);
            case "Reading" -> click(hobbyReading);
            case "Music" -> click(hobbyMusic);
            default -> throw new IllegalStateException("Hobby from input is not found in the list " + hobby);
        }
    }
    public void setCurrentAddress(String address){
        moveToElement();
        addText(address, this.currentAddress);
    }
    public void setState(String state){
        click(this.state);
        click(returnElementFromList(listOfStates, state));
    }

    @SneakyThrows
    public void submit(){
        click(this.submit);
        Thread.sleep(10000);
    }


}
