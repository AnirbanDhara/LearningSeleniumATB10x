package com.anirbandhara.ex01_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium02 {

    @Description("Open the URL")
    @Test
    public void test_Selenium02()
    {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.quit();
    }
}
