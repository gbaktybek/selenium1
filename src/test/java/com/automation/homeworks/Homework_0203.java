package com.automation.homeworks;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Homework3 extends CommonMethods {
    @Before
    public void setUp() {
        createDriver("https://magento.softwaretestingboard.com/");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void homework4 () throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        //2.Once on the page scroll down to the bottom of the page where the “Hot Sellers” section is visible
        WebElement hotSellersSection = driver.findElement(By.xpath("//h2"));

        actions.scrollToElement(hotSellersSection).build().perform();
        Thread.sleep(3000);

        //3. Select an item and hover over it
        WebElement item1 = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div"));

        actions.moveToElement(item1).build().perform();
        Thread.sleep(3000);

        //4. While hovering assert that the add to cart button is visible then select the size and color
        WebElement addToCartBtn1 = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[4]/div/div[1]/form/button"));

        Assert.assertTrue("Add to cart button is not displayed", addToCartBtn1.isDisplayed());

        WebElement sizeM = driver.findElement(By.xpath("//*[@id='option-label-size-143-item-168']"));
        WebElement colorBlue = driver.findElement(By.xpath("//*[@id='option-label-color-93-item-50']"));

        sizeM.click();
        colorBlue.click();
        Thread.sleep(3000);

        addToCartBtn1.click();
        Thread.sleep(3000);

        //5. Once item is added to cart page should reload
        //6. After page has been reloaded you can proceed to check out. (Either through the cart icon or the cart page)
        WebElement cart = driver.findElement(By.xpath("//div[2]/header/div[2]/div[1]/a"));
        WebElement checkoutBtn = driver.findElement(By.xpath("//*[@id='top-cart-btn-checkout']"));

        cart.click();
        Thread.sleep(3000);

        checkoutBtn.click();
        Thread.sleep(3000);

        //7. Once on checkout page fill out the form USE FAKE INFO (Try to challenge yourself and use complex locators)
        WebElement emailAddress = driver.findElement(By.xpath("//*[@id='customer-email'][1]"));
        WebElement firstName = driver.findElement(By.xpath("//*[@id='R8X79LM']"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id='P2JDNN8']"));
        WebElement company = driver.findElement(By.xpath("//*[@id='M1WIIBH']"));
        WebElement strAddress1 = driver.findElement(By.xpath("//*[@id='UTO689N']"));
        WebElement strAddress2 = driver.findElement(By.xpath("//*[@id='AHAXW26']"));
        WebElement strAddress3 = driver.findElement(By.xpath("//*[@id='T4Y3ITX']"));
        WebElement city = driver.findElement(By.xpath("//*[@id='HRSYBPM']"));
        WebElement stateDropdown = driver.findElement(By.xpath("//*[@id='ET6U8UY']"));
        WebElement zipCode = driver.findElement(By.xpath("//*[@id='F0JAF7J']"));
        WebElement countryDropdown = driver.findElement(By.xpath("//*[@id='SV74LGM']"));
        WebElement phoneNum = driver.findElement(By.xpath("//*[@id='RSUOPW5']"));
        WebElement shippingMethod = driver.findElement(By.xpath("//*[@id='checkout-shipping-method-load']"));
        WebElement nextBtn = driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/div/button"));

        Select statesDropdown = new Select(stateDropdown);
        Select countriesDropdown = new Select(countryDropdown);

        emailAddress.sendKeys("ccts@gmail.com");
        firstName.sendKeys("Cactus");
        lastName.sendKeys("Cactoid");
        company.sendKeys("Cactus Corporation");
        strAddress1.sendKeys("2323 East 13th St");
        strAddress2.sendKeys("Apt 112");
        strAddress3.sendKeys("");
        city.sendKeys("Brooklyn");
        statesDropdown.selectByValue("43");
        zipCode.sendKeys("11265");
        countriesDropdown.getFirstSelectedOption();
        phoneNum.sendKeys("857-645-6767");

        Thread.sleep(3000);


    }
}
