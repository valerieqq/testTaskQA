package main.PageElements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface TestElements extends WebPage {

    @FindBy("//div[@class='left-pannel']//span[text()='Practice Form']/..")
    AtlasWebElement btn_practiceForm();

    @FindBy("//input[@placeholder='First Name']")
    AtlasWebElement input_firstName();

    @FindBy("//input[@placeholder='Last Name']")
    AtlasWebElement input_lastName();

    @FindBy("//input[@name='gender']/../label[contains(.,'{{ gender }}')]/..")
    AtlasWebElement radio_gender(@Param("gender") String gender);

    @FindBy("//input[@placeholder='Mobile Number']")
    AtlasWebElement input_mobileNbr();

    @FindBy("//button[@id='submit']/..")
    AtlasWebElement btn_submit();

    @FindBy("//div[@class='modal-content']")
    AtlasWebElement modalContent();

    @FindBy("//div[@class='modal-header']/div[contains(@class,'title h4')]")
    AtlasWebElement modalHeader();

    @FindBy("//td[text()='{{ value }}']/../td[text()='{{ value2 }}']")
    AtlasWebElement submittedValues(@Param("value") String value, @Param("value2") String value2);

}
