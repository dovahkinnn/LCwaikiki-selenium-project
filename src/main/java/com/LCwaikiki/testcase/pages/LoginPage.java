package com.LCwaikiki.testcase.pages;

import com.LCwaikiki.testcase.Users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By userNameFieldBy = By.xpath("//*[@id=\"LoginEmail\"]");
    By passwordFieldBy = By.xpath("//*[@id=\"Password\"]");
    By loginButtonBy = By.xpath("//*[@id=\"loginLink\"]");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage login(User user) throws InterruptedException {
        sendKeys(userNameFieldBy, user.getEmail());
        sendKeys(passwordFieldBy, user.getPassword());
        click(loginButtonBy, 10);


        HomePage homePage = new HomePage(webDriver);
        homePage.waitForLoad();
        return homePage;
    }

}
