package com.automation.homeworks;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework1_0127 extends DriverUtils {
    @Before
    public void setUp() {
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void login() throws InterruptedException{
        WebDriver driver = getDriver();

        //login
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        Thread.sleep(500);

        //product page
        WebElement addToCartFirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartFirstItem.click();

        //shopping cart
        WebElement shoppingCartLink = driver.findElement(By.className("shopping_cart_link"));

        shoppingCartLink.click();

        Thread.sleep(500);

        // on cart page
        WebElement firstItem = driver.findElement(By.className("inventory_item_name"));
        Assert.assertTrue("verify item is added to cart", firstItem.isDisplayed());


    }
}
