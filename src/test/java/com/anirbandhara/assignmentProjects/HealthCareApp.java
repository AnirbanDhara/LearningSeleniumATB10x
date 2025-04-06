package com.anirbandhara.assignmentProjects;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HealthCareApp {

    @Description("TC1. Make Appointment on CuraHealthCareApp")
    @Test
    public void test_CuraHealthCare_Positive() throws InterruptedException {
        // 1. Open the URL
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // 2. Click "Make Appointment Button"
        //<a id="btn-make-appointment"
        // href="./profile.php#login"
        // class="btn btn-dark btn-lg">
        // Make Appointment
        // </a>

        WebElement appointmentButton = driver.findElement(By.id("btn-make-appointment"));
        appointmentButton.click();

        Thread.sleep(2000);

        // 3. Find the UserName input box and type username
        //<input
        // type="text"
        // class="form-control"
        // id="txt-username"
        // name="username"
        // placeholder="Username"
        // value="" autocomplete="off"
        // fdprocessedid="yiffs8">

        WebElement usrname_ibx = driver.findElement(By.id("txt-username"));
        usrname_ibx.sendKeys("John Doe");

        // 4. Find the PassWord input box and type password
        //<input
        // type="password"
        // class="form-control"
        // id="txt-password"
        // name="password"
        // placeholder="Password"
        // value="" autocomplete="off"
        // fdprocessedid="gcsbsh">
        WebElement password_ibx = driver.findElement(By.id("txt-password"));
        password_ibx.sendKeys("ThisIsNotAPassword");

        // 5. Click "Login" Button
        //<button
        // id="btn-login"
        // type="submit"
        // class="btn btn-default"
        // fdprocessedid="9om8jf">Login
        // </button>

        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        Thread.sleep(2000);

        // 6. check we are on "appointment" page

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://katalon-demo-cura.herokuapp.com/#appointment");


        // 7. quit the session
        driver.quit();
    }
}
