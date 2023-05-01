package TestCase;

import Data.JsonDataReader;
import Pages.AddBundlePage;
import Pages.PaymentMethodPage;
import Pages.PhoneNumberPage;
import base.TestBase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;


public class EG_AddBundleTest extends TestBase {
    CSVReader reader;

    @Test
    public void bundle_chosen() throws IOException, CsvValidationException, ParseException {

        JsonDataReader jsonobj= new JsonDataReader();
        jsonobj.JsonReader();
        AddBundlePage AddBundleObject = new AddBundlePage(driver);
        AddBundleObject.EssentialBundleCSV(jsonobj.countrycode,jsonobj.countryname,jsonobj.NewEssentialpackprice,jsonobj.OldEssentialpackprice);
        AddBundleObject.PackagesCSV(jsonobj.lightpackprice,jsonobj.Essentialpackprice,jsonobj.Premiumpackprice);
        AddBundleObject.Fight_SportsCSV(jsonobj.FightSport);
        AddBundleObject.chooseEssentialBundle();
        PaymentMethodPage PaymentMethodObject = new PaymentMethodPage(driver);
        PaymentMethodObject.Choose_the_payment_Method_EG(jsonobj.TvJaw,jsonobj.orange_company,jsonobj.Other_Company,jsonobj.PhoneName);
        PhoneNumberPage PhoneNumberObject = new PhoneNumberPage(driver);
        PhoneNumberObject.Send_the_PhoneNumber();
        }
        }
