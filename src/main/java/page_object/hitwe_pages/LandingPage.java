package page_object.hitwe_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_object.common.AbstractPage;

import java.util.List;

public class LandingPage extends AbstractPage {

    @FindBys({
            @FindBy(xpath = "//a[@href='#']")
    })
    private List<WebElement> appearanceOptions;

    @FindBy(xpath = "//select[@name='language']")
    private WebElement selectLanguage;


    public LandingPage(final WebDriver webDriver) {
        super(webDriver);
    }


    public void clickButtonToChooseAppearanceOption(final String sex, final String hair,
                                                   final String eyes, final String body) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(selectLanguage));
        for (WebElement option :appearanceOptions) {
               if (sex.toLowerCase().equals(option.getText().toLowerCase().trim())
                       || hair.toLowerCase().equals(option.getText().toLowerCase().trim())
                       || eyes.toLowerCase().equals(option.getText().toLowerCase().trim())
                       || body.toLowerCase().equals(option.getText().toLowerCase().trim())
               ) {
                   getWebDriverWait().until(ExpectedConditions.visibilityOf(option));
                   option.click();
            }
        }
    }
}
