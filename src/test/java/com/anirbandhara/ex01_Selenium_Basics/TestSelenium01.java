package com.anirbandhara.ex02_Selenium_Basics.ex01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

public class TestSelenium01 {

    @Description()
    @Test
    public void test_Selenium01()
    {
        // Open the URL
        WebDriver driver = new EdgeDriver();
        // new web driver instance --> POST request(localhost: 56055) to the browser, Create new session endpoint

        // Navigate the URL --> get the URL
        driver.get("https://app.vwo.com/#/login");

        // Assert the URL --> validation
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");


        // end the session
        driver.quit();

    }
}
