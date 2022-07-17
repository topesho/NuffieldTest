package com.pageObjects;

import com.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;


public class SearchPage {

    public WebDriver driver;

    public SearchPage(WebDriver driver) throws MalformedURLException {
        this.driver = Driver.getDriver();
    }


    By startLogo = By.xpath("//*[@class='nav__logo']");
    By findGym = By.xpath("//input[@id='location-finder__input-00000160-4eeb-de17-a579-dffb7ab70000']");
    By cookies = By.xpath("//span[contains(text(),'Accept cookies')]");

    public void NavigateToWebsite(String url) {
        driver.navigate().to(url);
    }

    public boolean assertStartLogo() {
        return driver.findElement(startLogo).isDisplayed();
    }

    public void acceptCookies() {
        driver.findElement(cookies).click();
    }

    public void enterFindGym(String gymLocation) {
        driver.findElement(findGym).click();
        driver.findElement(findGym).sendKeys(gymLocation);
        try {
            Thread.sleep(3000);
            driver.findElement(findGym).sendKeys(Keys.ARROW_DOWN);
            driver.findElement(findGym).sendKeys(Keys.RETURN);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }

    public boolean getGynName(String location) {
        WebElement gymResultLink = driver.findElement(By.xpath("//*[contains(@href,'/gyms/" + location + "') and @itemprop='url']"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", gymResultLink);
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@href,'/gyms/" + location + "') and @itemprop='url']"))).isDisplayed();
    }

    public void clickGynName(String location) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href,'/gyms/" + location + "') and @itemprop='url']"))).click();
    }

}




