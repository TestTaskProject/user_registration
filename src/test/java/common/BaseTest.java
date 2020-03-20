package common;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.WebDriverFactory;


@Getter
public abstract class BaseTest {

    private WebDriver webDriver;

    @BeforeClass
    @Parameters("chromeBrowser")
    public void startDriver(final String driver) {
        webDriver = WebDriverFactory.implementDriver(driver);
    }

    @AfterClass
    public void stopDriver() {
        webDriver.close();
    }

}
