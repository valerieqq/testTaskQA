package main.TestSteps;

import main.Data.StudentForm;
import main.Enums.Gender;
import main.PageElements.TestElements;
import main.WebDriver.WebDriverConfig;
import main.WebDriver.WebDriverSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class TestSteps extends WebDriverSteps {

    public TestSteps openMainPage() {
        onTest().open("https://demoqa.com/forms");
        return this;
    }

    public TestSteps goToPractice() {
        onTest().btn_practiceForm().click();
        return this;
    }

    public TestSteps enterFirstName(String firstName) {
        onTest().input_firstName().sendKeys(firstName);
        return this;
    }

    public TestSteps checkFirstNameRequired() {
        Assert.assertNotNull(onTest().input_firstName().getAttribute("required"));
        return this;
    }

    public TestSteps enterLastName(String lastName) {
        onTest().input_lastName().sendKeys(lastName);
        return this;
    }

    public TestSteps checkLastNameRequired() {
        Assert.assertNotNull(onTest().input_lastName().getAttribute("required"));
        return this;
    }

    public TestSteps selectGender(Gender gender) {
        onTest().radio_gender(gender.toString()).click();
        return this;
    }

    public TestSteps checkGenderRequired() {
        Assert.assertNotNull(onTest().findElement(By.xpath("//input[@name='gender']")).getAttribute("required"));
        return this;
    }

    public TestSteps enterMobileNbr(String mobileNbr) {
        onTest().input_mobileNbr().sendKeys(mobileNbr);
        return this;
    }

    public TestSteps checkMobileRequired() {
        Assert.assertNotNull(onTest().input_mobileNbr().getAttribute("required"));
        return this;
    }

    public TestSteps clickSubmit() {
        ((JavascriptExecutor) getWebDriverConfig().getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", onTest().btn_submit());
        onTest().btn_submit().click();
        return this;
    }

    public TestSteps modalDisplayed() {
        onTest().modalContent().isDisplayed();
        return this;
    }

    public TestSteps checkSubmittedData(StudentForm studentForm) {
        onTest().modalHeader().getText().equals("Thanks for submitting the form");
        onTest().submittedValues("Student Name",
                String.format("%s %s", studentForm.getFirstName(), studentForm.getLastName())).isDisplayed();
        onTest().submittedValues("Gender", studentForm.getGender().toString()).isDisplayed();
        onTest().submittedValues("Mobile", studentForm.getMobile()).isDisplayed();
        return this;
    }

    public TestSteps checkRequiredFields() {
        checkFirstNameRequired();
        checkLastNameRequired();
        checkGenderRequired();
        checkMobileRequired();
        return this;
    }

    public TestSteps(WebDriverConfig getWDConfig) {
        super(getWDConfig);
    }

    public TestElements onTest() {
        return onPage(TestElements.class);
    }
}
