
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class SauceLabsTest {
    public static void main(String[] args) throws Exception {
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

        WebDriver driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
        Thread.sleep(10000);
        // Run your test
        driver.get("https://www.google.com");
        System.out.println("Page Title is: " + driver.getTitle());
        Thread.sleep(10000);
        driver.get("https://app.eu-central-1.saucelabs.com/wd/hub");
        System.out.println("Page Title is: " + driver.getTitle());
        Thread.sleep(10000);
        driver.get("https://www.linkedin.com/in/anup-kumar-singh-a5926519/");
        System.out.println("Page Title is: " + driver.getTitle());
        
        
        // End session
        driver.quit();
    }
}
