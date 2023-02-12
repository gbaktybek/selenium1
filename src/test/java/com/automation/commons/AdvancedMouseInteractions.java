package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdvancedMouseInteractions extends CommonMethods{
    @Before
    public void setUp() {
        createDriver("https://demoqa.com/buttons");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void learnAdvancedMouseInteractions() throws InterruptedException{
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Right')]"));

        //Actions class have a lot of different methods to perform various different advanced mouse interactions and actions
        //in this case we are calling the .doubleClick() method and passing the element we wait to double click on
        //we are calling the .build() method in order to build the actual sequence
        //and then the .perform() method which actually performs the actions
        actions.doubleClick(doubleClickBtn).build().perform();

        Thread.sleep(3000);

        //the actions .contextClick() method performs a right click/ context (synonyms) on the webElement that is passed
        //as a parameter
        actions.contextClick(rightClickBtn).build().perform();

        Thread.sleep(3000);

        //in this case we are performing the same double click, but we are using the .moveToElement method first
        // move the mouse to the element and then perform the double click
        actions.moveToElement(doubleClickBtn).doubleClick().build().perform();
    }

    @Test
    public void learnDragAndDrop() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(draggable, droppable).build().perform();

        Thread.sleep(3000);

        driver.navigate().to("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        //.dragAndDropBy(WebElement, xOffset,yOffset) method will drag the element by the given x and y offset
        actions.dragAndDropBy(slider, 50 , 0).build().perform();

        Thread.sleep(3000);

        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        Thread.sleep(2500);

        WebElement hoverIcon1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));

        //here we are using the .moveToElement() method to essentially hover a specific element
        actions.moveToElement(hoverIcon1).build().perform();

        WebElement viewProfileLink = driver.findElement(By.xpath("//div[@class='figure'][1]/a"));

        actions.keyDown(Keys.COMMAND).click(viewProfileLink).keyUp(Keys.COMMAND).build().perform();

        Thread.sleep(3000);
    }

    @Test
    public void learnScroll() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        loginToSauceDemo();

        WebElement footer = driver.findElement(By.className("footer_copy"));

        //scrollToElement() method will scroll to the WebElement passed as parameter
        actions.scrollToElement(footer).build().perform();

        Thread.sleep(3000);


        //scrollByAmount() method will scroll by the specified amount on the x and y
        actions.scrollByAmount(0,500).build().perform();
    }


}
