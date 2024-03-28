package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WebTablePage extends BasePage {
    String namePerson;
    String lastNamePErson;
    String emailPerson;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit;
    @FindBy(xpath = "//button[@id=\"addNewRecordButton\"]")
    private WebElement addRecord;
    @FindBy(xpath = "//input[@placeholder=\"First Name\"]")
    private WebElement name;
    @FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
    private WebElement lastName;
    @FindBy(xpath = "(//li[@id= 'item-3'])[1]")
    private WebElement webTablesOption;
    @FindBy(xpath = "//input[@placeholder=\"name@example.com\"]")
    private WebElement email;
    @FindBy(xpath = "//input[@placeholder=\"Age\"]")
    private WebElement age;
    @FindBy(xpath = "//input[@placeholder=\"Salary\"]")
    private WebElement salary;
    @FindBy(xpath = "//input[@placeholder=\"Department\"]")
    private WebElement department;
    @FindBy(xpath = "//span[@id= 'delete-record-3']")
    private WebElement deleteItem;
    @FindBy(xpath = "//div[@class='category-cards']//div[2]//div[1][normalize-space() = 'Forms']")
    private WebElement form;
    @FindBy(xpath = "//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-md-3')]/div[contains(@class,'left-pannel')]/div[contains(@class,'accordion')]/div[1]/span[1]/div[1]")
    private WebElement elementsOption;
    @FindBy(xpath = "//div[@class = 'ReactTable -striped -highlight']//div[@class = 'rt-tbody']//div[1]")
    private List<WebElement> listOfRecords;
    @FindBy(xpath = "//div[@role= 'row']//div[7]//span[2]")
    private List<WebElement> deleteItemBtn;
    @FindBy(xpath = "//div[@role= 'row']")
    private List<WebElement> rowsItems;

    public void navigateToElements(){
        moveToElement();
        click(form);
        waitPage().until(ExpectedConditions.visibilityOf(elementsOption));
        click(elementsOption);
        waitPage().until(ExpectedConditions.visibilityOf(webTablesOption));
        click(webTablesOption);
        moveToElement();
    }


    public void registrationPerson(String name, String lastName, String email, String age, String salary, String department ){
        namePerson = name;
        lastNamePErson = lastName;
        emailPerson = email+"@gmail.com";
        waitPage().until(ExpectedConditions.visibilityOf(addRecord));
        click(addRecord);
        addText(name, this.name);
        addText(lastName, this.lastName);
        addText(emailPerson, this.email);
        addText(age, this.age);
        addText(salary, this.salary);
        addText(department, this.department);
    }

    public void submitBtn(){
        click(submit);
    }


    public boolean checkTable(){
        boolean isItemSaved =false;
        for (WebElement listOfRecord : listOfRecords) {
            if (listOfRecord.getText().contains(namePerson) &&
                    listOfRecord.getText().contains(lastNamePErson) &&
                    listOfRecord.getText().contains(emailPerson)) {
                isItemSaved = true;
            }
        }
        return isItemSaved;
    }

    public boolean deleteItemAndCheck(){
        for (int i = 1; i < rowsItems.size();i++) {
            if (rowsItems.get(i).getText().contains(namePerson) ||
                    rowsItems.get(i).getText().contains(lastNamePErson) ||
                    rowsItems.get(i).getText().contains(emailPerson)) {
                    click(deleteItemBtn.get(i-1));
                    break;
            }
        }
        return !checkTable();
    }
}
