package com.example.stepdef;


import com.aventstack.extentreports.Status;
import com.example.Base.DriverFactory;
import com.example.hooks.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SampleSteps {      
	   private static int value; 
   
	   
    @Given("I open the Google homepage")
    public void i_open_the_google_homepage() throws InterruptedException, MalformedURLException {
    	DriverFactory driverFactory = new DriverFactory();
    	
    	WebDriver driver=driverFactory.getDriver("firefox");
    	driver.get("http://localhost:8080");
    	Thread.sleep(40000);
    	//driver.get("https://anupksingh4u.github.io./HandsOn/");
    	
    	
//    	driver.get("https://www.google.com");
//    	Thread.sleep(20000); // Wait for 20 seconds to see the page load
//    	driver.get("https://github.com/AnupKSingh4u/Extent");
    	Thread.sleep(20000); // Wait for 20 seconds to see the page load
//    	WebElement promptArea=driver.findElement(By.id("prompt-textarea"));
//    	promptArea.click();
//    	promptArea.sendKeys("What is Saucelabs cloud platform?");
//    	Thread.sleep(4000);
//    	WebElement sendButton = driver.findElement(By.xpath("//button[@id='composer-submit-button']"));
//    	sendButton.click(); 
//    	Thread.sleep(40000);
//    	promptArea.click();
//    	promptArea.sendKeys("What are the international political equations behind iran and Israil war?");
//    	Thread.sleep(4000);
//    	sendButton.click();
//    	Thread.sleep(40000);
    	
    	//driver.get("https://anupksingh4u.github.io./HandsOn/");
    	driver.quit();
    }
    
    @Given("I want to write a step with precondition")
    public void i_want_to_write_a_step_with_precondition() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }
    @Given("some other precondition")
    public void some_other_precondition() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }
    @When("I complete action")
    public void i_complete_action() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }
    @When("some other action")
    public void some_other_action() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @When("yet another action")
    public void yet_another_action() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }
    @Then("I validate the outcomes")
    public void i_validate_the_outcomes() {
        // Write code here that turns the phrase above into concrete actions
    	 Assertions.assertEquals("Google", "Google");
     
     
	  //  throw new io.cucumber.java.PendingException();

    }
    @Then("check more outcomes")
    public void check_more_outcomes() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }

    
    @Given("I want to write a step with {string}")
    public void i_want_to_write_a_step_with(String name) {
        System.out.println("Executing: step with name -> " + name);
    }

    @When("I check for the {int} in step")
    public void i_check_for_the_value_in_step(Integer value) {
    	SampleSteps.value=value;
        System.out.println("Executing: check for value -> " + value);
    }

//    @Then("I verify the {string} in step")
//    public void i_verify_the_status_in_step(String status) {
//        System.out.println("Executing: verify status -> " + status);
//    }
    
    @Then("I verify the {string} in step")
    public void i_verify_the_status_in_step(String expectedStatus) {
        try {
            String actualStatus = getActualStatusSomehow();
          //  Assert.assertEquals("Mismatch in status!", expectedStatus, actualStatus);
            Assertions.assertEquals(expectedStatus, actualStatus);
            Hooks.scenarioNode.log(Status.PASS, "Verified status: " + actualStatus);
        } catch (AssertionError | Exception e) {
            setStepError(e); // Log to hook
            Hooks.scenarioNode.log(Status.FAIL, "Assertion failed: " + e.getMessage());
            throw e;
        }
    }
 
    private String getActualStatusSomehow() {
        // Simple logic for demo: odd = success, even = Fail
        return (value % 2 == 0) ? "success" : "Fail";
    }
    
    public static void setStepError(Throwable error) {
        Hooks.lastStepError.set(error);
    }
}