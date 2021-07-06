import main.Data.StudentForm;
import main.Enums.Gender;
import main.WebDriver.Config;
import org.testng.annotations.Test;


public class TestSuite extends Config {

    @Test
    public void formIsSubmitted() {
        StudentForm studentForm = new StudentForm(
                "Valerie",
                "Ubei-Volk",
                Gender.randomGender(),
                "0689848764");
        formsPage()
                .openMainPage()
                .goToPractice()
                .enterFirstName(studentForm.getFirstName())
                .enterLastName(studentForm.getLastName())
                .selectGender(studentForm.getGender())
                .enterMobileNbr(studentForm.getMobile())
                .clickSubmit()
                .modalDisplayed()
                .checkSubmittedData(studentForm);
    }

    @Test
    public void formIsEmpty() {
        formsPage()
                .openMainPage()
                .goToPractice()
                .clickSubmit()
                .checkRequiredFields();
    }
}
