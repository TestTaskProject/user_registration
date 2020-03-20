package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private WebDriverFactory() {}

    public static WebDriver implementDriver(final String driverName) {
        switch (driverName.toLowerCase()) {
            case "chrome": System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
            return new ChromeDriver();
            case "firefox": System.getProperty("webdriver.firefox.driver", "geckodriver.exe");
            return new FirefoxDriver();
            default:
                throw new IllegalStateException("Not supported web driver type found");
        }
    }
}
