package com.automation.practice;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice01 extends CommonMethods {
    @Test
    public void practice1() throws InterruptedException{
        WebDriver driver = getDriver();

        //1. open website and login
        loginToSauceDemo();
        Thread.sleep(3000);

        //2. assert cart is displayed and click cart
        WebElement cartButton = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a"));
        Assert.assertTrue("Cart button is not displayed", cartButton.isDisplayed());
        cartButton.click();
        Thread.sleep(3000);

        //3. assert checkout is displayed
        WebElement checkoutButton = driver.findElement(By.xpath("//*[@id='checkout']"));
        Assert.assertTrue("Checkout is not displayed", checkoutButton.isDisplayed());
        Thread.sleep(3000);

        //4. go back to the product page, add item to cart
        driver.navigate().back();
        Thread.sleep(3000);
        //add item to cart
        WebElement addToCartFirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartFirstItem.click();
        Thread.sleep(3000);

        //5. go back to the cart page, assert item is there
        driver.navigate().forward();
        WebElement firstItem = driver.findElement(By.className("inventory_item_name"));
        Assert.assertTrue("verify item is added to cart", firstItem.isDisplayed());
        Thread.sleep(3000);


    }

    @Before
    public void setUp() {
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}
