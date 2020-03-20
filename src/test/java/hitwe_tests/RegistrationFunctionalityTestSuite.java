package hitwe_tests;

import common.BaseTest;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import page_object.hitwe_pages.LandingPage;
import page_object.hitwe_pages.ProfilePage;
import page_object.hitwe_pages.RegisterPage;
import utilities.PropertyReader;


public class RegistrationFunctionalityTestSuite extends BaseTest {

    @Test
    @Parameters({"sex", "hair", "eyes","body", "name", "gender", "age"})
    public void registerOnWebsiteTest(final String sex, final String hair, final String eyes, final String body,
                                      final String name, final String gender, final String age) {

        PropertyReader propertyReader = new PropertyReader();
        final String landingPageUrl = propertyReader.readProperty("hitwe.main.page.url");
        getWebDriver().get(landingPageUrl);

        LandingPage landingPage = new LandingPage(getWebDriver());
        landingPage.clickButtonToChooseAppearanceOption(sex, hair, eyes, body);

        RegisterPage registerPage = new RegisterPage(getWebDriver());
        registerPage.fillInRegisterForm(name, gender, age);

        ProfilePage profilePage = new ProfilePage(getWebDriver());
        final User expectedUser = new User(name, age);
        final User actualUser = profilePage.getUserData();

        ReflectionAssert.assertReflectionEquals("Created user data does not match to expected",
                expectedUser, actualUser);
    }

    @Test
    public void uploadProfileImageTest() {

        ProfilePage profilePage = new ProfilePage(getWebDriver());
        profilePage.clickcloseHitweAppInterstialAdScreen();
        profilePage.clickphotoMenu();
        profilePage.clickUploadPhotoButton();
        profilePage.uploadProfilePhoto();
        profilePage.clickAddChosenPhotoButton();
        Assert.assertFalse(profilePage.isPhotoUploaded(), "Photo is not uploaded");
    }
}
