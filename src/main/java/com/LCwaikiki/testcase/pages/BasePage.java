package com.LCwaikiki.testcase.pages;


import com.LCwaikiki.testcase.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.*;

public class BasePage extends WebDriverHelper {
    By loginOrRegisterButtonBy = By.xpath("//*[@id=\"header-profile-section\"]/div");
    By loginButtonBy = By.xpath("//*[@id=\"header-profile-section\"]/div");
    By searchBoxBy = By.xpath("//*[@id=\"search\"]");



    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage getLoginPage() throws InterruptedException {
        moveToElement(loginOrRegisterButtonBy);
        click(loginButtonBy, 10);



        return new LoginPage(webDriver);
    }
    public String getAccountText(){
        return getText(loginOrRegisterButtonBy);
    }

    public SearchResultPage search(String keyword) {

        webDriver.findElement(searchBoxBy).sendKeys(keyword + Keys.ENTER);
        return new SearchResultPage(webDriver);
    }


}
