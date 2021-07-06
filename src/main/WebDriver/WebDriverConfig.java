package main.WebDriver;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverConfig {

    private WebDriver driver;
    private Atlas atlas;

    public void startWebDriver() {
        System.setProperty("webdriver.chrome.driver", "tools\\chromedriver.exe");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("safebrowsing.enabled", "false");
        prefs.put("download.prompt_for_download", "false");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        atlas = new Atlas(new WebDriverConfiguration(driver));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public Atlas getAtlas() {
        return atlas;
    }
}
