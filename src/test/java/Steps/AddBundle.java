package Steps;

import Pages.AddBundlePage;
import Pages.PaymentMethodPage;
import Pages.PhoneNumberPage;
import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class AddBundle extends TestBase {
    AddBundlePage AddBundleObject ;
    PaymentMethodPage PaymentMethodObject;
    PhoneNumberPage PhoneNumberObject;
    @Given("The user will open the page and chooses the country logo {string}")
    public  void The_user_will_open_the_page_and_chooses_the_country_logo(String FightSport) throws InterruptedException {  AddBundleObject = new AddBundlePage(driver);

        AddBundleObject.EssentialBundle();
        AddBundleObject.Packages();
        AddBundleObject.Fight_SportsCSV(FightSport);
    }
    @When("User will choose the essential bundle {string},{string},{string},{string}")
    public  void User_will_choose_the_essential_bundle(String Tvjaw,String orange_company,String Other_Company,String PhoneName) {
        AddBundleObject.chooseEssentialBundle();
        PaymentMethodObject= new PaymentMethodPage(driver);
        PaymentMethodObject.Choose_the_payment_Method_EG(Tvjaw,orange_company,Other_Company,PhoneName);
    }
    @Then("^The user will continue the cycle and add a phone number$")
    public  void Check_Currency_Type_Price ()
    {
        PhoneNumberObject = new PhoneNumberPage(driver);
        PhoneNumberObject.Send_the_PhoneNumber();
    }
}