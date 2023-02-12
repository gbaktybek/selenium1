package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload extends DriverUtils {
    @Before
    public void setUp() {
        createDriver("https://demoqa.com/upload-download");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void LearnFileUpload() {
        WebDriver driver = getDriver();

        WebElement fileUploadInput = driver.findElement(By.cssSelector("input#uploadFile"));

        fileUploadInput.sendKeys("/Users/baktybekovaguldana47gmail.com/Desktop/TextFile.txt");
    }
}
