package com.qualitest.pages;

import com.qualitest.utils.DurationUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;

    @Value("${baseurl}")
    protected String baseURL;

    public void initiateDriver(String browserName) throws Exception {
        switch (browserName) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(baseURL);
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new Exception("Unsupported browser specification " + browserName);
        }
    }

    public void openApplication(String applicationToOpen, String browserName) throws Exception {
        initiateDriver(browserName);
        driver.manage().window().maximize();
        driver.get(applicationToOpen);
        driver.manage().timeouts().implicitlyWait(DurationUtil.LONG, TimeUnit.MINUTES);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getWebElement(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }
}
