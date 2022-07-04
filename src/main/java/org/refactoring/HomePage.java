package org.refactoring;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePage extends BasePage {

    public HomePage(ChromeDriver driver) {
        super(driver);
    }

    By loginButtonBy = By.xpath("//nav/div[@class='header_user_info']/a[@href='https://sweetness.com.ua/my-account']");

    public AuthorizationPage clickLoginButton(){
        driver.findElement(loginButtonBy).click();
        return new AuthorizationPage((ChromeDriver) driver);
    }
}
