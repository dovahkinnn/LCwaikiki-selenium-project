package com.LCwaikiki.testcase.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SearchResultPage extends BasePage{
    By showMoreButton = By.cssSelector("#divModels > div:nth-child(10) > div > div.paging-process > a");
    By body = By.xpath("/html/body");

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public By randomSelectProductBy() {
        Random random = new Random();
        int rando = random.nextInt(30) + 1;
        return By.xpath("/html/body/div[5]/div[3]/div[2]/div[7]/div/div[1]/div[" + rando + "]/a");



    }

    public void choosePage() {
        webDriver.findElement(body).sendKeys(Keys.ARROW_UP);

        click(showMoreButton,5);


    }

    public ProductDetailsPage goToProductDetails() throws InterruptedException {
        Thread.sleep(2000);

        click(randomSelectProductBy(),10);
        return new ProductDetailsPage(webDriver);
    }


}
