package com.automation.commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown extends CommonMethods{
    @Before
    public void setUp() {
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }

    @Test
    public void learnDropDown() throws  InterruptedException{
        WebDriver driver = getDriver();

        driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

        WebElement dropdown = driver.findElement(By.xpath("//select"));
        WebElement selectCountryTitle = driver.findElement(By.id("Select country"));

        System.out.println(selectCountryTitle.getAttribute("id"));
        System.out.println(selectCountryTitle.getAttribute("class"));
        System.out.println(selectCountryTitle.getAttribute("aria-controls"));
        System.out.println(selectCountryTitle.getAttribute("role"));

        System.out.println("-------------------------------------");
        //select class has a constructor with parameter WebElement therefore we need to pass an element to the class
        //the element we pass should be the dropdown we want to manipulate
        Select countriesDropdown = new Select(dropdown);

        //System.out.println(countriesDropdown.getOptions().get(1).getText());;

        //.getOptions() method returns List<WebElement> of all the option tags are children to the current select tag
        List<WebElement> optionList = countriesDropdown.getOptions();


        //prints all the options from list
        //cycling through a list of options created on line 31 and printing the text stores inside the tag
        // and the attribute "value"
        for (WebElement option : optionList) {
            System.out.println(option.getText() + "\t" + option.getAttribute("value"));
        }

        //select class has a lot of different methods that do various different things such as selecting a specific
        //option in side of the select tag, returning a specific value, etc
        countriesDropdown.selectByVisibleText("Bermuda");

        Thread.sleep(3000);
    }
}
