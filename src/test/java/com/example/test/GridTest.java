package com.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        
        if(browser.equalsIgnoreCase("chrome")) {
            caps.setBrowserName("chrome");
        } else if(browser.equalsIgnoreCase("firefox")) {
            caps.setBrowserName("firefox");
        }
        
        caps.setPlatform(Platform.LINUX);  // Grid nodes run Linux containers

        // URL of Selenium Hub
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    }

    @Test
    public void openGoogleTest() throws InterruptedException {
        driver.get("https://www.google.com");
        Thread.sleep(10000);
        driver.findElement(By.name("q")).sendKeys("Selenium Grid");
        driver.findElement(By.name("q")).submit();
        
        Thread.sleep(120000); // Just to see the browser open
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) driver.quit();
    }
}
