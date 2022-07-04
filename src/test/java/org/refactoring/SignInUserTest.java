package org.refactoring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;



public class SignInUserTest extends BaseTestClass{

    @Test
    public void signInUserTest() {
        HomePage homePage = new HomePage((ChromeDriver) driver);
        new HomePage((ChromeDriver) driver).clickLoginButton();

        AuthorizationPage authorizationPage = new AuthorizationPage((ChromeDriver) driver);
        new AuthorizationPage((ChromeDriver) driver)
                .enterExistingUserData()
                .clickSignInButton();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://sweetness.com.ua/my-account");
        assertThat(authorizationPage.getEmail_Of_existing_User()).isEqualTo("elenarobertson37+50@gmail.com");
        assertThat(authorizationPage.getPassword_Of_existing_User()).isEqualTo("555555");
        System.out.println("true");
    }
}
