package Pages;

import Utilities.DBconnection;
import base.PageBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class AddBundlePage extends PageBase {

    public AddBundlePage(WebDriver Loginddriver)
    {
        super(Loginddriver);
    }
    WebDriverWait wait = new WebDriverWait(driver, WAIT);
  public void EssentialBundle() {
      WebElement EgyptLogo=driver.findElement(By.id("country-name"));
      clickButton(EgyptLogo);
      clickButton(driver.findElement(By.id("eg-contry-lable")));
      Assert.assertEquals(driver.findElement(By.id("country-name")).getText(),"مصر");
      Assert.assertEquals(driver.findElement(By.xpath("//div[@style='color: #676767;']")).getText(),"ابتداءا من 50.00 جنيه مصري/بالشهر");
      Assert.assertEquals(driver.findElement(By.xpath("//div[@class='trial-cost'] //b[text()='7.00']")).getText(),"7.00");
  }
    public void Packages()
    {
        Assert.assertEquals(driver.findElement(By.id("currency-لايت")).getText(),"0.25 دولار أمريكي/شهر"); //0.25 جنيه مصرى/شهر
        Assert.assertEquals(driver.findElement(By.id("currency-الأساسية")).getText(),"0.5 دولار أمريكي/شهر"); //0.5 جنيه مصرى/شهر
        Assert.assertEquals(driver.findElement(By.id("currency-بريميوم")).getText(),"1 دولار أمريكي/شهر"); //1 جنيه مصرى/شهر
    }
    public void chooseEssentialBundle()
    {
        clickButton(driver.findElement(By.cssSelector ("a.button.trial-button")));
        Assert.assertEquals(driver.findElement(By.className("payment-header")).getText(),"طريقة الدفع او السداد");
    }
    public void EssentialBundleCSV(String countrycode,String countryName,String oldessentialpack,String newessentialpack) {
        WebElement EgyptLogo=driver.findElement(By.id("country-name"));
        clickButton(EgyptLogo);
        clickButton(driver.findElement(By.id(""+countrycode+"-contry-lable")));
        Assert.assertEquals(driver.findElement(By.id("country-name")).getText(),countryName);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@style='color: #676767;']")).getText(),newessentialpack);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='trial-cost'] //b[text()='7.00']")).getText(), oldessentialpack);
    }
    public void EssentialBundleCSV_OtherCountry(String countrycode,String countryName,String newessentialpack) {
        WebElement EgyptLogo=driver.findElement(By.id("country-name"));
        clickButton(EgyptLogo);
        clickButton(driver.findElement(By.id(""+countrycode+"-contry-lable")));
        Assert.assertEquals(driver.findElement(By.id("country-name")).getText(),countryName);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.trial-cost")).getText(),newessentialpack);
    }
    public void PackagesCSV(String lightpackprice, String Essentialpackprice, String Premiumpackprice)
    {
        Assert.assertEquals(driver.findElement(By.id("currency-لايت")).getText(),lightpackprice); //0.25 جنيه مصرى/شهر
        Assert.assertEquals(driver.findElement(By.id("currency-الأساسية")).getText(),Essentialpackprice); //0.5 جنيه مصرى/شهر
        Assert.assertEquals(driver.findElement(By.id("currency-بريميوم")).getText(),Premiumpackprice); //1 جنيه مصرى/شهر
    }
    public void Fight_SportsCSV(String FightSport)
    {
        String fightsport=driver.findElement(By.xpath("(//div[@class='plan-section extensions']//div[@class='plan-names']/div)[4]")).getText();
        if (fightsport!="متوفر")
        {
            Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='plan-section extensions']//div[@class='plan-names']/div)[4]")).getText(), FightSport); //5.33 جنيه مصرى/شهر
            Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='plan-section extensions']//div[@class='plan-names']/div)[5]")).getText(), FightSport); //5.33 جنيه مصرى/شهر
            Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='plan-section extensions']//div[@class='plan-names']/div)[6]")).getText(), FightSport); //5.33 جنيه مصرى/شهر
        }
        }
}