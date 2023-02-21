package ashtvivahTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Feature",glue="com/stepsDefinations_Astvivah")
public class Test_Runner extends AbstractTestNGCucumberTests {

}
