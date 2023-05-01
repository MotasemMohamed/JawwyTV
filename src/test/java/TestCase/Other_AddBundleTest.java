package TestCase;

import Data.JsonDataReader;
import Data.JsonDataReader2;
import Pages.AddBundlePage;
import Pages.PaymentMethodPage;
import Pages.PhoneNumberPage;
import base.TestBase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;


public class Other_AddBundleTest extends TestBase {
    CSVReader reader;
    @Test
    public void bundle_chosen() throws IOException, CsvValidationException, ParseException {

        JsonDataReader2 jsonobj= new JsonDataReader2();
        jsonobj.JsonReader();
        AddBundlePage AddBundleObject = new AddBundlePage(driver);
        AddBundleObject.EssentialBundleCSV_OtherCountry(jsonobj.countrycode,jsonobj.countryname,jsonobj.NewEssentialpackprice);
        AddBundleObject.PackagesCSV(jsonobj.lightpackprice,jsonobj.Essentialpackprice,jsonobj.Premiumpackprice);
        AddBundleObject.Fight_SportsCSV(jsonobj.FightSport);
        AddBundleObject.chooseEssentialBundle();
        PaymentMethodPage PaymentMethodObject = new PaymentMethodPage(driver);
        PaymentMethodObject.Choose_the_payment_Method_CSV(jsonobj.PaymentMethod,jsonobj.Tvjaw,jsonobj.Total_Payment,jsonobj.PhoneName);
        PhoneNumberPage PhoneNumberObject = new PhoneNumberPage(driver);
        PhoneNumberObject.Send_the_PhoneNumber_CSV(jsonobj.Tvjaw,jsonobj.Total_Payment);
        //Assert.assertEquals(driver.findElement(By.cssSelector("div.book-success")).getText(),"تم حجز موعدك بنجاح");
        }
        }
