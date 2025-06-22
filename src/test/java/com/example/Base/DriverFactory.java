package com.example.Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	

    
	public WebDriver getDriver(String browser) throws MalformedURLException {
	    String username = "oauth-anupksingh4u-d864f";
	    String accessKey = "4406f55b-95a5-4dfd-8d84-1628bce8f0a5";
	    String remoteUrl = "https://" + username + ":" + accessKey + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
	    URL url = new URL(remoteUrl);

	    // Sauce-specific options — define first
	    MutableCapabilities sauceOptions = new MutableCapabilities();
	    sauceOptions.setCapability("name", "My First Test");
	    sauceOptions.setCapability("build", "Build_1");
	    sauceOptions.setCapability("tunnelIdentifier", "TUNNEL1"); // ✅ Set BEFORE adding it to browserOptions

	    if (browser.equalsIgnoreCase("chrome")) {
	        ChromeOptions browserOptions = new ChromeOptions();
	        browserOptions.setCapability("platformName", "Windows 10");
	        browserOptions.setCapability("browserVersion", "latest");
	        browserOptions.setCapability("sauce:options", sauceOptions);
	        return new RemoteWebDriver(url, browserOptions);

	    } else if (browser.equalsIgnoreCase("firefox")) {
	        FirefoxOptions browserOptions = new FirefoxOptions();
	        browserOptions.setCapability("platformName", "Windows 11");
	        browserOptions.setCapability("browserVersion", "latest");
	        browserOptions.setCapability("sauce:options", sauceOptions);
	        return new RemoteWebDriver(url, browserOptions);

	    } else if (browser.equalsIgnoreCase("edge")) {
	        EdgeOptions browserOptions = new EdgeOptions();
	        browserOptions.setCapability("platformName", "Windows 11");
	        browserOptions.setCapability("browserVersion", "latest");
	        browserOptions.setCapability("sauce:options", sauceOptions);
	        return new RemoteWebDriver(url, browserOptions);

	    } else {
	        throw new IllegalArgumentException("Browser not supported: " + browser);
	    }
	}

}

