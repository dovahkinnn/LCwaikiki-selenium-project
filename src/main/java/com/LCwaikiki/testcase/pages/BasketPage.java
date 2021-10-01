package com.LCwaikiki.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    private final By priceInTheBasketBy = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div[2]/div[1]/div[3]/div/span[2]");
    private By numberOfProductsBy = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/a[2]");
    private By totalProductBy = By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div:nth-child(1) > div > span");
    private By deleteProductBy = By.className("cart-square-link");
    private By emptyBasketBy = By.xpath("//*[@id=\"ShoppingCartContent\"]/div[1]/div/div/p[1]");
    private By acceptDeleteProductBy = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/a[1]");


    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String priceInTheBasket(){
       return webDriver.findElement(priceInTheBasketBy).getText();
    }

    public void setNumberOfProducts(){
        click(numberOfProductsBy,10);
    }

    public String getTotalProduct(){
        return webDriver.findElement(totalProductBy).getText();
    }

    public void deleteProduct(){

        click(deleteProductBy,10);
        click(acceptDeleteProductBy,10);


    }

    public String isEmpty(){
        return webDriver.findElement(emptyBasketBy).getText();
    }
}
