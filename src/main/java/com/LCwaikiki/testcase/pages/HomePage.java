package com.LCwaikiki.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    By mainBy = By.xpath("/html/body");
    By closeCookiesButtonBy = By.xpath("/html/body/div[5]/div/div[2]/div/button");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHomePageTitle(){
        return webDriver.getTitle();
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainBy));
    }

    public void closeCookiesPopUp(){
        click(closeCookiesButtonBy,10);
    }
}
