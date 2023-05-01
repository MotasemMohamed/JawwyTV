package Pages;

import base.PageBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethodPage extends PageBase {
    public PaymentMethodPage(WebDriver Loginddriver)
    {
        super(Loginddriver);
    }
  public void Choose_the_payment_Method_EG(String Tvjaw,String orange_company,String Other_Company,String PhoneName)  {
      Assert.assertEquals(driver.findElement(By.id("order-tier-price")).getText(),Tvjaw);
      Assert.assertEquals(driver.findElement(By.id("etisalat_egy-price")).getText(),Other_Company);
      Assert.assertEquals(driver.findElement(By.id("vodafone_egy-price")).getText(),Other_Company);
      Assert.assertEquals(driver.findElement(By.id("orange_egy-price")).getText(),orange_company);
      Assert.assertEquals(driver.findElement(By.id("we_egy-price")).getText(),Other_Company);
      clickButton(driver.findElement(By.id("btnChoosePaymentMethod")));
      Assert.assertEquals(driver.findElement(By.className("payment-header")).getText(),PhoneName);
    }
    public void Choose_the_payment_Method_CSV(String PaymentMethodPrice,String TvJaw,String Totall,String PhoneName)  {
        Assert.assertEquals(driver.findElement(By.id("du_uae-price")).getText(),PaymentMethodPrice);
        Assert.assertEquals(driver.findElement(By.id("etisalat_uae-price")).getText(),PaymentMethodPrice);
        Assert.assertEquals(driver.findElement(By.id("order-tier-price")).getText(),TvJaw);
        Assert.assertEquals(driver.findElement(By.id("order-total-price")).getText(),Totall);
        clickButton(driver.findElement(By.id("btnChoosePaymentMethod")));
        Assert.assertEquals(driver.findElement(By.className("payment-header")).getText(),PhoneName);
    }
}