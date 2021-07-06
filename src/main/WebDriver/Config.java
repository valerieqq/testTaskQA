package main.WebDriver;

import main.TestSteps.TestSteps;
import main.WebDriver.WebDriverConfig;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class Config {

    TestSteps steps;
    WebDriverConfig driverConfig;


    protected TestSteps formsPage() {
        return steps;
    }

    @BeforeMethod(alwaysRun = true)
    public void before(Method method) {
        driverConfig = new WebDriverConfig();
        driverConfig.startWebDriver();
        steps = new TestSteps(driverConfig);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        driverConfig.stopDriver();
    }

}
