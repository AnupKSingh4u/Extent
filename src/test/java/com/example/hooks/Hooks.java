package com.example.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.*;

public class Hooks {


    private static ExtentReports extent;
    public static ExtentTest scenarioNode;
    public static ThreadLocal<Throwable> lastStepError = new ThreadLocal<>();    
    
    @BeforeAll
    public static void setup() {

            ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    

    @Before
    public void beforeScenario(Scenario scenario) {
        scenarioNode = extent.createTest(scenario.getName());
        lastStepError.remove(); // clear before new scenario
    }

    @AfterStep
    public void logStep(Scenario scenario) {
        Throwable error = lastStepError.get();
        if (scenario.isFailed() && error != null) {
            scenarioNode.fail("Step failed: " + error.getMessage());
            scenarioNode.fail(error); // logs full stack trace
        } else {
            scenarioNode.pass("Step passed");
        }
        lastStepError.remove(); // Clear after logging
    }

    @After
    public void afterScenario(Scenario scenario) {
        scenarioNode.info("Scenario finished: " + scenario.getStatus());
    }

    @AfterAll
    public static void afterAll() {
        extent.flush();
    }

    // Make this available to step definitions
    public static void setStepError(Throwable error) {
        lastStepError.set(error);
    }
}
