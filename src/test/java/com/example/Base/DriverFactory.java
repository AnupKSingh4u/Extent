package com.example.Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	

    
     public WebDriver getDriver(String browser) throws MalformedURLException {
    	try {
    	
    	//if(driver== null) {	

    		String username = "oauth-anupksingh4u-d864f";
            String accessKey = "4406f55b-95a5-4dfd-8d84-1628bce8f0a5";
            
            String remoteUrl = "https://" + username + ":" + accessKey + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "latest");

            // Sauce-specific options
            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("name", "My First Test");
            sauceOptions.setCapability("build", "Build_1");
            capabilities.setCapability("sauce:options", sauceOptions);
            sauceOptions.setCapability("tunnelIdentifier", "TUNNEL1");

            WebDriver driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
            return driver;
    //	}
    	} catch (MalformedURLException e) {
			throw new RuntimeException("Invalid Sauce Labs URL: " + e.getMessage());
	
    	}
         catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage());
		}

		
        
    }
}

