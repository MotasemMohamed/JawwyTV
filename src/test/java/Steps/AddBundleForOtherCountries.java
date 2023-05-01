package Steps;

import Pages.AddBundlePage;
import Pages.PaymentMethodPage;
import Pages.PhoneNumberPage;
import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class AddBundleForOtherCountries extends TestBase {
    AddBundlePage AddBundleObject ;
    PaymentMethodPage PaymentMethodObject;
    PhoneNumberPage PhoneNumberObject;
    /*@BeforeClass
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
    }*/
    @Given("The user will open the page and chooses the country logo {string},{string},{string},{string},{string},{string},{string}")
    public void the_user_chooses_the_country_logo(String countrycode,String countryname,String NewEssentialpackprice,String lightpackprice,String Essentialpackprice,String Premiumpackprice,String FightSport) {

        AddBundleObject = new AddBundlePage(driver);
        AddBundleObject.EssentialBundleCSV_OtherCountry(countrycode,countryname,NewEssentialpackprice);
        AddBundleObject.PackagesCSV(lightpackprice,Essentialpackprice,Premiumpackprice);
        AddBundleObject.Fight_SportsCSV(FightSport);
    }
    @When("User will choose the essential bundle for other countries {string},{string},{string},{string}")
    public  void User_will_choose_the_essential_bundle_for_other_countries(String PaymentMethodPrice,String TvJaw,String Totall,String PhoneName) {
        AddBundleObject.chooseEssentialBundle();
        PaymentMethodObject= new PaymentMethodPage(driver);
        PaymentMethodObject.Choose_the_payment_Method_CSV(PaymentMethodPrice,TvJaw,Totall,PhoneName);
    }
    @Then("The user will continue the cycle and add a phone number for other countries {string},{string}")
    public  void Check_Currency_Type_Price_for_other_countries (String TvJaw,String Total_Payment)
    {
        PhoneNumberObject = new PhoneNumberPage(driver);
        PhoneNumberObject.Send_the_PhoneNumber_CSV(TvJaw,Total_Payment);
    }
}
