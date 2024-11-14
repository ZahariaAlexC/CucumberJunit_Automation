package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class CreateDriverInstance {
    protected static WebDriver driver_local;
    protected static Actions action;

    public static WebDriver driverInstanceChrome() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver_local = new ChromeDriver(options);
            driver_local.manage().window().maximize();
            driver_local.manage().deleteAllCookies();
            action = new Actions(driver_local);
        return driver_local;
    }

    public static WebDriver driverInstanceEdge() {
        if(driver_local == null) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver_local = new EdgeDriver(options);
            driver_local.manage().window().maximize();
            driver_local.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver_local;
    }


    public static WebDriver driverInstanceFirefox() {
        if(driver_local == null) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origin=*");
            driver_local = new FirefoxDriver(options);
            driver_local.manage().window().maximize();
            driver_local.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver_local;
    }
}
