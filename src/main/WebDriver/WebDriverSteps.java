package main.WebDriver;

import io.qameta.atlas.webdriver.WebPage;
import main.WebDriver.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebDriverSteps {

    final protected WebDriverConfig webDriverConfig;

    public WebDriverSteps(WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
    }

    protected <T extends WebPage> T onPage(Class<T> page) {
        return webDriverConfig.getAtlas().create(webDriverConfig.getDriver(), page);
    }

    public WebDriverConfig getWebDriverConfig() {
        return webDriverConfig;
    }
}
