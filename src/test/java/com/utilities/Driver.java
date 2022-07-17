package com.utilities;


import com.Docker.DockerStart;
import com.Docker.DockerStop;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Driver extends BasePage {

    private static final Driver instance = new Driver();

    public static WebDriver driver;
    private static Browser browser;

    public static String remote_url = "http://localhost:4444/wd/hub";


    private enum Browser {
        Chrome, Firefox, RemoteDriver
    }

    private Driver() {
        initSelectedBrowser();
    }

    public static WebDriver getDriver() throws MalformedURLException {
        return instance.initDriver();
    }


    public WebDriver initDriver() throws MalformedURLException {
        if (driver == null) {
            switch (browser) {
                case Chrome:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case Firefox:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case RemoteDriver:
                    try {
                        DockerStart.startDocker();
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    DesiredCapabilities cap = new DesiredCapabilities();
                    FirefoxOptions options = new FirefoxOptions();
                    cap.setCapability("Firefox", options);
                    driver = new RemoteWebDriver(new URL(remote_url), cap);
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        }

        return driver;
    }


    public static void tearDown() {
        instance.closeDriver();
    }


    /**
     * grabs the browser set in the command line, or default to chrome
     */
    private void initSelectedBrowser() {
        String cmdBrowser = System.getProperty("browser");

        if (cmdBrowser == null) {
            browser = Browser.Chrome;
        } else {
            browser = Browser.valueOf(cmdBrowser);
        }
    }

    public void closeDriver() {
        if (driver != null) {
            synchronized (Driver.class) {
                if (driver != null) {
                    driver.quit();
                    driver = null;
                }
            }
        }
    }
}
