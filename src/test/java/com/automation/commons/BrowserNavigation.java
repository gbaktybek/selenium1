package com.automation.commons;

import com.automation.utils.DriverUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BrowserNavigation extends CommonMethods{
    @Before
    public void setUp() {
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }



    @Test
    public void learnBrowserNavigation() throws InterruptedException{
        WebDriver driver = getDriver();

        Thread.sleep(3000);

        //driver.navigate().to(url) essentially opens up a different url in the same driver session
        //it is the equaivalent of using the search bar to go from current website to different one.
        driver.navigate().to("http://18.116.88.132:8080/bank/home");

        Thread.sleep(3000);

        //will bring you to the original url you were on before going into a new page/link
        driver.navigate().back();

        Thread.sleep(3000);

        // it does the opposite of the .back() method and will bring you back to the page you were before going back
        driver.navigate().forward();
        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);
    }


}
