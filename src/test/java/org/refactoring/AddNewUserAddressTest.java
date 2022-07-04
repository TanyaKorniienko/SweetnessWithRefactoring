package org.refactoring;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AddNewUserAddressTest extends BaseTestClass{

    @Test
    public void addUserAddress() {
        HomePage homePage = new HomePage((ChromeDriver) driver);
        new HomePage((ChromeDriver) driver).clickLoginButton();

        AuthorizationPage authorizationPage = new AuthorizationPage((ChromeDriver) driver);
        new AuthorizationPage((ChromeDriver) driver)
                .enterExistingUserData()
                .clickSignInButton();

        UserInfoPage userInfoPage = new UserInfoPage((ChromeDriver) driver);
        new UserInfoPage((ChromeDriver) driver).openUserAddressPage();

        UserAddressPage userAddressPage = new UserAddressPage((ChromeDriver) driver);
        new UserAddressPage((ChromeDriver) driver)
                .clickAddAddressButton()
                .addUserAddress()
                .clickSubmitButton();

        assertThat(userAddressPage.getAddress()).startsWith("Sak");
        assertThat(userAddressPage.getCity()).isEqualTo("Kiev");
    }

}
