package com.LCwaikiki.testcase;
import  com.LCwaikiki.testcase.TestCase;


import com.LCwaikiki.testcase.BaseTest;
import com.LCwaikiki.testcase.Users.User;
import com.LCwaikiki.testcase.pages.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class TestCase extends BaseTest {
    @Test
    public void LCwaikikiTest() throws InterruptedException {
        String title = "LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki";
        String title2="LC Waikiki - Online Alışveriş Sitesi, Moda Senin Seçimin - LC Waikiki";
        String email = "hakanulu72@hotmail.com";
        String password = "Ev7STZ4D*WkxKWe";


        HomePage homePage = new HomePage(webDriver);
        String webDriverTitle = homePage.getHomePageTitle();

        Log4j.info("Title: " + webDriverTitle);
        assertEquals(webDriverTitle, title);

        Log4j.info("Go to Login Page");
        LoginPage loginPage = homePage.getLoginPage();
        Log4j.info("email: " + email + ", password: " + password);
        User user = new User(email, password);
        loginPage.login(user);
        Log4j.info("Go to Home Page");
        String accountButtonText = homePage.getAccountText();
        Log4j.info("The text written on the My Account button is: " + accountButtonText);
        assertTrue(accountButtonText.contains("Hesabım"));


        Log4j.info("The word 'pantolan' is entered in the search box.");

        SearchResultPage searchResultPage = homePage.search("pantolan");
        Thread.sleep(3000);
        searchResultPage.scrollToPageEnd();
        Log4j.info("The page selected from the search results page opens.");

        searchResultPage.choosePage();
        searchResultPage.scrollToPageEnd();
        Thread.sleep(3000);


        Log4j.info("Go to Product details page");
        ProductDetailsPage productDetailsPage = searchResultPage.goToProductDetails();

        Log4j.info("Product price information is received.");
        String productPrice = productDetailsPage.productPrice();
        productDetailsPage.ClickSize();
        searchResultPage.scrollToPage("300");
        Log4j.info("The selected product is added to the basket.");
        productDetailsPage.addToBasket();

        Log4j.info("Go to my cart page.");
        BasketPage basketPage = productDetailsPage.goToBasket();
        Log4j.info("The price on the product page is compared with the price of the product in the basket.");
        assertEquals(productPrice, basketPage.priceInTheBasket());

        Log4j.info("The number of products is increased.");
        basketPage.setNumberOfProducts();
        Thread.sleep(2000);
        assertTrue(basketPage.getTotalProduct().contains("Sepetim (2 Ürün)"));
        Log4j.info("The product is deleted from the basket.");
        basketPage.deleteProduct();
        Thread.sleep(2000);
        String basketMessage = "Sepetinizde ürün bulunmamaktadır.";
        Log4j.info("Check if the basket is empty");
        assertEquals(basketMessage, basketPage.isEmpty());

    }

}
