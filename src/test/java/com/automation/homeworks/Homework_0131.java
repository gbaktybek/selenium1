package com.automation.homeworks;

import com.automation.commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homework3_0131 extends CommonMethods {
    @Before
    public void setUp() {
        createDriver("https://www.timeanddate.com/timer/");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void startResetTimer() throws InterruptedException{
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMinutes(2));

        WebElement startButton = driver.findElement(By.xpath("//div[@class='toolbox toolbox--manual fadeIn']/button[@title='Start timer']"));
        WebElement resetButton = driver.findElement(By.xpath("//div[@class='toolbox toolbox--manual fadeIn']/button[@title='Reset and start over']"));
        WebElement timer = driver.findElement(By.xpath("span.timeLeft"));

        startButton.click();
        driverWait.until(ExpectedConditions.textToBePresentInElement(timer, "00:01:45"));
        startButton.click();
        Assert.assertTrue("Time does not match ", timer.getText().contains("00:01:45"));
        resetButton.click();
        Assert.assertTrue(timer.getText().contains("00:02:00"));

        Thread.sleep(8000);

        System.out.println(timer.getText());
    }

    @Test
    public void filterPriceLowToHigh() throws InterruptedException {
        WebDriver driver = getDriver();

        //1.open and login to saucedemo
        driver.navigate().to("https://www.saucedemo.com/");
        loginToSauceDemo();

        //2.click on the filter, select price low to high
        WebElement filter = driver.findElement(By.xpath("//select"));
        Select filterDropdown = new Select(filter);
        filterDropdown.selectByValue("lohi");
        Thread.sleep(4000);

        //3. Assert that the span with active-option class value has changed to the option you selected
        WebElement optionLowHigh = driver.findElement(By.xpath("//select/option[@value='lohi']"));
        WebElement spanText = driver.findElement(By.cssSelector("span.active_option"));

        Assert.assertTrue("Span value has not changed to the option you selected", optionLowHigh.getText().equalsIgnoreCase(spanText.getText()));
        Thread.sleep(3000);

        //OPTIONAL Advanced Task
        List<WebElement> inventoryItemPrices = driver.findElements(By.cssSelector("div.inventory_item_price"));
        List<Double> itemPricesDouble = new ArrayList<>();

        for (int i = 0; i < inventoryItemPrices.size(); i++) {
            itemPricesDouble.add(i,Double.parseDouble(inventoryItemPrices.get(i).getText().substring(1)));
        }

        double min = itemPricesDouble.get(0);
        for(int i = 0; i<itemPricesDouble.size(); i++ ){
            if (itemPricesDouble.get(i) < min) {
                min = itemPricesDouble.get(i);
            }
        }
        double firstItemPrice = Double.parseDouble(inventoryItemPrices.get(0).getText().substring(1));

        Assert.assertTrue("first item is not the cheapest one", min==firstItemPrice);

        System.out.println(min);
        System.out.println(firstItemPrice);


        //4. Now refresh the page and ensure that the filter changed back to its original state
        driver.navigate().refresh();
        Thread.sleep(3000);

        Select filterDropdown2 = new Select(driver.findElement(By.xpath("//select")));
        String defaultOption = filterDropdown2.getFirstSelectedOption().getText();
        System.out.println(defaultOption);

        WebElement spanText2 = driver.findElement(By.cssSelector("span.active_option"));

        Assert.assertTrue("filter didn't change back to its original state", defaultOption.equalsIgnoreCase(spanText2.getText()));
        Thread.sleep(5000);


    }

}
