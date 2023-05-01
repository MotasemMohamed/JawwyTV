package Pages;

import base.PageBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhoneNumberPage extends PageBase {
    public PhoneNumberPage(WebDriver Loginddriver)
    {
        super(Loginddriver);
    }
  public void Send_the_PhoneNumber()  {
      Assert.assertEquals(driver.findElement(By.id("order-tier-price")).getText(),"10 جنية مصري/الشهر");
      Assert.assertEquals(driver.findElement(By.id("selected-tier-price")).getText(),"كان 50 جنية مصري/الشهر\n" +
              "عرض رمضان");
  }
    public void Send_the_PhoneNumber_CSV(String TvJaw,String Total_Payment)  {
        Assert.assertEquals(driver.findElement(By.id("order-tier-price")).getText(),TvJaw);
        Assert.assertEquals(driver.findElement(By.id("order-total-price")).getText(),Total_Payment);
        Assert.assertEquals(driver.findElement(By.id("selected-tier-price")).getText(),TvJaw);
    }
}