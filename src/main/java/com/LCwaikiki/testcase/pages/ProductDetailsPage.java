package com.LCwaikiki.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    private By lowProductPriceBy  = By.xpath("//*[@id=\"rightInfoBar\"]/div[1]/div/div[2]/div/div/div/span[2]");

    private By addToBasketButtonBy = By.xpath("//*[@id=\"pd_add_to_cart\"]");
    private By goToBasketButtonBy = By.xpath("/html/body/div[5]/div[2]/div[1]/div[4]/div/div[4]/a");
    private By Sizes = By.xpath("//*[@id=\"option-size\"]/a[1]");

    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String productPrice(){
       webDriver.findElement(lowProductPriceBy).getText();

        return getText(lowProductPriceBy);
    }
    public void ClickSize(){
        click(Sizes,30);
    }
    public void addToBasket(){
        click(addToBasketButtonBy,30);
    }
    public BasketPage goToBasket(){
        click(goToBasketButtonBy,10);
        return new BasketPage(webDriver);
    }
}
