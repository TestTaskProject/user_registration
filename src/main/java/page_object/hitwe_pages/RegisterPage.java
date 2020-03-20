package page_object.hitwe_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import page_object.common.AbstractPage;

import java.util.Date;

public class RegisterPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInputField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInputField;


    @FindBy(xpath = "//select[@name='gender']")
    private WebElement genderSelect;

    @FindBy(xpath = "//select[@name='age']")
    private WebElement ageSelect;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;


    public RegisterPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void fillInRegisterForm(final String name, final String gender, final String age) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(nameInputField));
        nameInputField.sendKeys(name);
        final String generatedEmail = generateEmail();
        emailInputField.sendKeys(generatedEmail);
        chooseGender(gender);
        chooseAge(age);
        registerButton.click();
    }

    private String generateEmail() {
        Date date = new Date();
        final long emailName =  date.getTime();
        final String emailDomain = "@testmail.com";
        return String.format("%s%s", emailName,emailDomain);
    }

    private void chooseGender(final String gender) {
        Select selectForGender = new Select(genderSelect);
        selectForGender.selectByVisibleText(gender);
    }

    private void chooseAge(final String age) {
        Select selectForAge = new Select(ageSelect);
            selectForAge.selectByValue(age);
    }
}
