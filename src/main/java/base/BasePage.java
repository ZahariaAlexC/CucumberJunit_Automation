package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BasePage {
    private static final int SECONDS_WEB_DRIVER_WAIT = 10;

    private final WebDriver driver;
    protected Actions action;

    public BasePage() {
            driver = CreateDriverInstance.driver_local;
            PageFactory.initElements(driver, this);
            action = CreateDriverInstance.action;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void SwitchToNextTab() {
            ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));
    }

    public WebDriverWait waitPage() {
            return new WebDriverWait(driver, Duration.ofSeconds(SECONDS_WEB_DRIVER_WAIT));
    }

    protected void addText(String inputText, WebElement locator) {
            clear(locator);
            locator.sendKeys(inputText);
    }

    protected void clear(WebElement locator) {
            click(locator);
            if (getOperationSystem().contains("Windows")) {
                locator.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            } else if (getOperationSystem().contains("Mac OS X")) {
                locator.sendKeys(Keys.chord(Keys.COMMAND, "a"));
            }
    }

    protected void click(WebElement locator) {
            waitPage().until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
    }

    protected void moveToElement() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void javascriptExecutor(int x, int y) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }
    protected String getPageTitle() {
            return driver.getTitle();

    }
        protected String getUrl() {
            return driver.getCurrentUrl();

    }

        protected void scrollDown() {
            action.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform();
    }

        protected void scrollUp() {
            action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).perform();
    }

    protected  WebElement returnElementFromList(List<WebElement> elementList, String option){
            for(WebElement element : elementList){
                if(element.getText().equals(option)){
                    return element;
                }
            }
            return null;
    }
    private String getOperationSystem() {
            return System.getProperty("os.name");
    }
}
