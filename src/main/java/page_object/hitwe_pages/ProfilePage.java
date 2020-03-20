package page_object.hitwe_pages;

import dto.User;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page_object.common.AbstractPage;

import java.io.File;

public class ProfilePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='prof-card-name-hold']")
    private WebElement userProfileData;

    @FindBy(xpath = "//a[@class='interstial-close']")
    private WebElement closeHitweAppInterstialAdScreen;

    @FindBy(xpath = "//a[contains(@href,'photo')]")
    private WebElement photoMenu;

    @FindBy(xpath = "//a[@do-click='addPhotos']")
    private WebElement uploadPhotoButton;

    @FindBy(xpath = "//a[@class='in-button']")
    private WebElement uploadPhotoFromInstagramButton;

    @FindBy(xpath = "//input[@id='photo']")
    private WebElement uploadPhotoInput;

    @FindBy(xpath = "//a[@class='add-btn']")
    private WebElement addChosenPhotoButton;

    @FindBy(xpath = "//div[@class='avatar-placeholder']")
    private WebElement avatarPlaceholder;

    private static final String PROFILE_USER_NAME = "./div[@class='prof-name']";
    private static final String PROFILE_USER_AGE = "./div[@class='prof-meta']";

    public ProfilePage(final WebDriver webDriver) {
        super(webDriver);
    }

    public User getUserData() {
        final String profileUserName = userProfileData.findElement(By.xpath(PROFILE_USER_NAME)).getText().trim();
        final String profileUserAge = StringUtils.getDigits(userProfileData.findElement(By.xpath(PROFILE_USER_AGE))
                                                 .getText().trim());
        return new User(profileUserName, profileUserAge);
    }

    public void clickcloseHitweAppInterstialAdScreen() {
        closeHitweAppInterstialAdScreen.click();
    }

    public void clickphotoMenu() {
        photoMenu.click();
    }

    public void clickUploadPhotoButton() {
        uploadPhotoButton.click();
    }

    public void uploadProfilePhoto() {
        final String absolutePath = getAbsolutePathForProfilePhoto();
        getWebDriverWait().until(ExpectedConditions.visibilityOf(uploadPhotoFromInstagramButton));
        uploadPhotoInput.sendKeys(absolutePath);
    }

   public void clickAddChosenPhotoButton() {
       getWebDriverWait().until(ExpectedConditions.elementToBeClickable(addChosenPhotoButton));
       addChosenPhotoButton.click();
   }

    public Boolean isPhotoUploaded() {
        return avatarPlaceholder.getAttribute("style").isEmpty();
    }

    private String getAbsolutePathForProfilePhoto() {
        File imageFile = new File("TestImage.jpg");
        return imageFile.getAbsolutePath();
    }
}
