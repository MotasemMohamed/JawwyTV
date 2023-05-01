package Runner;

import base.TestBase;
import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(features = "src/test/java/features",glue = {"Steps"},plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase {

}
