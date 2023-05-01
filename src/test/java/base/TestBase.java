package base;

import Pages.*;
import Utilities.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
    //public void startDriver( String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

        }  else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }else if (browserName.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\drivers\\operadriver.exe");
            driver = new OperaDriver();
            WebDriver webDriver=new FirefoxDriver();

        }else if (browserName.equalsIgnoreCase("chrome-headless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            DesiredCapabilities caps= new DesiredCapabilities();
            caps.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(caps);
            driver = new ChromeDriver(option);
        }
       driver.manage().deleteAllCookies();
        driver.get("https://subscribe.jawwy.tv/eg-ar?");
        driver.get("https://subscribe.jawwy.tv/eg-ar?");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeDriver() {
         driver.quit();
    }
    @AfterMethod
    public void screenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenShot(driver, result.getName());
        }
    }
}