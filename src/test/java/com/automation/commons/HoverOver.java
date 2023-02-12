package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverOver extends CommonMethods{
    @Before
    public void setUp() {
        createDriver("https://magento.softwaretestingboard.com/");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void practiceHover() {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        WebElement firstItem = driver.findElement(By.xpath("//li[@class='product-item'"));
    }
}
