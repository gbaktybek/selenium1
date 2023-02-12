package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserSynchronization extends DriverUtils {
    @Before
    public void setUp() {
        createDriver("https://demoqa.com/progress-bar");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void learnWaits() throws InterruptedException{
        WebDriver driver = getDriver();
        //creating an object of WebDriverWait class and passing the driver (to access current driver session) and
        //the duration of secs we want to wait for the expected condition
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));


        //*[@id="progressBar"]/div
        // #progressBar div.progress-bar
        WebElement startButton = driver.findElement(By.xpath("//*[@id='startStopButton']"));
        WebElement progressBAr = driver.findElement(By.xpath("//*[@id='progressBar']/div"));

        startButton.click();

        //using our driverWait variable to call until method to wait for testToBePresentInElement() condition to return true
        //Note: if the condition is true before the time is up it will not wait for the wait time
        driverWait.until(ExpectedConditions.textToBePresentInElement(progressBAr,"100%"));

        Thread.sleep(5000);

        Assert.assertTrue("Value does not match expected",progressBAr.getText().contains("100%"));
    }
}
