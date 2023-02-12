package com.automation.practice;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeForms extends CommonMethods {
    @Before
    public void setUp() {
        createDriver("https://www.techlistic.com/p/selenium-practice-form.html");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void practiceForms() {
        WebDriver driver = getDriver();

//        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
//        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
//        WebElement gender = driver.findElement();
//        WebElement yearsOfExp = driver.findElement();
//        WebElement date = driver.findElement();
//        WebElement profession = driver.findElement();
//        WebElement automationTool = driver.findElement();
//        WebElement continents = driver.findElement();
//        WebElement seleniumCommands = driver.findElement();
//        WebElement uploadImage = driver.findElement();
    }
}
