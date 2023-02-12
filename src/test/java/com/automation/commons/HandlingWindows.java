package com.automation.commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.ArrayList;
import java.util.Set;

public class HandlingWindows extends CommonMethods{
    @Before
    public void setUp() {
        createDriver("https://demoqa.com/browser-windows");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void learnHandlingWindows() throws InterruptedException {
        WebDriver driver = getDriver();

        WebElement tabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
        WebElement windowButton = driver.findElement(By.id("windowButton"));

        //.getWindowHandle() returns the String window of the current window
        //here we are saving the window handle of thr current window as a String var so that we can return to it later
        String primaryWindow = driver.getWindowHandle();
        tabButton.click();
        windowButton.click();

        Thread.sleep(1000);

        //System.out.println(driver.getWindowHandle());

        //here we are taking the return type Set<String> and casting it to an ArrayList for easy access
        Set<String> windowSet = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<>(windowSet);

        //here we are creating a for each loop to cycle through the elements of the window list, and then we are
        //making sure that the current window isn't the primary window we are originally in
        for (String window : windowsList) {
            //here we are switch to the current window that passed all above conditions
            if (!window.equals(primaryWindow)) {
                Thread.sleep(3000);
                //here we are switching to the current window that passed all above conditions
                driver.switchTo().window(window);
                WebElement header = driver.findElement(By.tagName("h1"));
                System.out.println(header.getText());
                //this method is different from driver.quit(), it closes the specific window that is currently active
                driver.close();
            }
        }

        driver.switchTo().window(primaryWindow);
        Thread.sleep(3000);

    }

    @Test
    public void windowHandlingExample() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        Actions actions = new Actions(driver);

        String primaryWindow = driver.getWindowHandle();

        WebElement shopNewYogaBtn = driver.findElement(By.xpath("//span[contains(text(),'Shop New Yoga')]"));

        actions.keyDown(Keys.COMMAND).click(shopNewYogaBtn).keyUp(Keys.COMMAND).build().perform();

        //since driver.getWindowHandles() method returns a set of window handles we can pass it to the constructor
        //of the arraylist which will cast it into arraylist
        ArrayList<String> windowList = new ArrayList<>(driver.getWindowHandles());

        for (String windowHandle : windowList) {
            if (!windowHandle.equals(primaryWindow)) {
                driver.switchTo().window(windowHandle);

                //here we are checking the url of the current window that is active has the text we are looking for
                if (!driver.getCurrentUrl().contains("/collections/yoga-new.html")) {
                    driver.close();
                }
            }
        }

        //here on out we are in a new window

        WebElement category = driver.findElement(By.xpath("//li[@class='item category8']/strong"));

        Assert.assertTrue("Category does not match expected",
                category.getText().equalsIgnoreCase("new luma yoga collection"));

        Thread.sleep(3000);

        //closing the current tab
        driver.close();
        //switching to the original window
        driver.switchTo().window(primaryWindow);

        shopNewYogaBtn = driver.findElement(By.xpath("//span[contains(text(),'Shop New Yoga')]"));

        Assert.assertTrue("Shop new yoga button is not visible", shopNewYogaBtn.isDisplayed());


    }
}
