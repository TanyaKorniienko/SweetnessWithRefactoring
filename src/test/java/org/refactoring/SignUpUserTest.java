package org.refactoring;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpUserTest extends BaseTestClass {

    @Test
    public void signUpUserTest() {
        HomePage homePage = new HomePage((ChromeDriver) driver);
        new HomePage((ChromeDriver) driver).clickLoginButton();

        AuthorizationPage authorizationPage = new AuthorizationPage((ChromeDriver) driver);
        new AuthorizationPage((ChromeDriver) driver)
                .setUserEmail()
                .startCreateUserButton();

        RegistrationPage registrationPage = new RegistrationPage((ChromeDriver) driver);
        new RegistrationPage((ChromeDriver) driver)
                .enterNewUserData()
                .submitUserRegistration();

        assertThat(authorizationPage.getNew_User_email()).startsWith("elena").endsWith("@gmail.com");
        assertThat(registrationPage.getNewUserPassword()).isEqualTo("123456").hasSize(6);
        assertThat(registrationPage.getLastName()).isEqualTo("Robertson");
        System.out.println("true");
    }
}
