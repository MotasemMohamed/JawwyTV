package Runner;

import base.TestBase;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features2",glue = {"Steps"},plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner2 extends TestBase {

}
