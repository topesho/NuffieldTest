package com.pageObjects;

import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;


public class SelectedGymPage {

    public WebDriver driver;

    public SelectedGymPage(WebDriver driver) throws MalformedURLException {
        this.driver = Driver.getDriver();
    }

    By gymContactName = By.xpath("//*[@class='gym-hero__title__long']");

    public String getGymFullName() {
        return driver.findElement(gymContactName).getText();
    }

}




