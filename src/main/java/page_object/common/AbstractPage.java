package page_object.common;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertyReader;

import java.util.concurrent.TimeUnit;

@Data
public abstract class AbstractPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private PropertyReader propertyReader;

    public AbstractPage(final WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait =  new WebDriverWait(webDriver,20);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver, this);
    }
}
