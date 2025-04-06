package com.anirbandhara.assignmentProjects;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Katalon_App_Flow {

    @Description("TC1. Make Appointment on CuraHealthCareApp and Logout")
    @Test
    public void test_CuraHealthCare_Positive(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        // 1. Open the URL
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // 2. Click "Make Appointment Button"
        WebElement make_appointment_btn = driver.findElement(By.xpath("//a [@id= \"btn-make-appointment\"]"));
        make_appointment_btn.click();

        String login_page_URL = driver.getCurrentUrl();

        Assert.assertTrue(login_page_URL.contains("profile.php#login"));

        // 3. Find the UserName and Password text box , enter username and password
        WebElement username_textbox = driver.findElement(By.xpath("//input[@id = \"txt-username\"]"));
        username_textbox.sendKeys("John Doe");

        WebElement password_textbox = driver.findElement(By.xpath("//input[@id = \"txt-password\"]"));
        password_textbox.sendKeys("ThisIsNotAPassword");

        // 4. Click Login button
        WebElement login_btn = driver.findElement(By.xpath("//button[@ type = \"submit\"]"));
        login_btn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String appointment_page_URL = driver.getCurrentUrl();
        Assert.assertTrue(appointment_page_URL.contains("#appointment"));

        // 5. Select "Seoul CURA Healthcare Center" option from dropdown
        WebElement facility_static_select = driver.findElement(By.xpath("//select[@name = \"facility\"]"));
        facility_static_select.click();

        Select seoul_healthcare_select = new Select(facility_static_select);
        seoul_healthcare_select.selectByValue("Seoul CURA Healthcare Center");

        // 6. Check "Apply for re-admission" checkbox
        WebElement apply_checkbox = driver.findElement(By.xpath("//input[@type = \"checkbox\"]"));
        apply_checkbox.click();

        // 7. Click "Medicaid" radio button
        WebElement medicaid_radio_btn = driver.findElement(By.xpath("//input[@id= \"radio_program_medicaid\"]"));
        medicaid_radio_btn.click();

        // 8. Select date from "date picker" class
        WebElement calender_span = driver.findElement(By.xpath("//span[@class= \"glyphicon glyphicon-calendar\"]"));
        calender_span.click();
        WebElement date = driver.findElement(By.xpath("//div[@class = \"datepicker-days\"]/table/tbody/tr[3]/td[4]"));
        date.click();

        // 9. Type comment in "Comment" textarea
        WebElement txtarea_cmt = driver.findElement(By.xpath("//textarea[@ id = 'txt_comment']"));
        txtarea_cmt.sendKeys("Book a admission");

        // 10. Click "Book Appointment" button
        WebElement appointment_btn = driver.findElement(By.xpath("//button[@type ='submit']"));
        appointment_btn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

        // 11. Click on close menu and select "logout" from dropdown
        WebElement toggle_btn = driver.findElement(By.xpath("//a[@id = \"menu-toggle\"]"));
        toggle_btn.click();
        WebElement logout = driver.findElement(By.xpath("//a[@ href = 'authenticate.php?logout']"));
        logout.click();


        driver.quit();

    }
}
