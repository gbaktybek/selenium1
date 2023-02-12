package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtils {
    private static WebDriver driver;

    public static void createDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/automation/driver/chromedriver");

        driver = new ChromeDriver();

        //set up an implicit wait that waits the Duration.ofSeconds() for every element while checking every 500
        //mili seconds before throwing NoSuchElementFoundException
        //Note: if the element exist before the time is up it will not wait for the wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();

        driver.get(url);

    }

    public void quitDriver() {
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
