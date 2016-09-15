package com.sauceevaluation;


import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.UUID;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by mehmetgerceker on 12/7/15.
 */

public class TestCasesClass extends BaseClass {

    /**
     * Runs a simple test verifying if the email input is functional.
     * @throws InvalidElementStateException
     */
 @Test(dataProvider = "hardCodedBrowsers")
    public void verifyEmailInputTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
        
	 	//System.out.println("in test case 1");
	 	String emailInputText = "abc@gmail.com";

        this.createDriver(browser, version, os, method.getName());
    
        WebDriver driver = this.getWebDriver();
        // Navigate to the page
        driver.get("https://saucelabs.com/test/guinea-pig");

        // get page object
        SitePage page = SitePage.getPage(driver);

        /*
         enterEmailText page is an exposed "service",
             which interacts with the email input field element by sending text to it.
        */
        page.enterEmailText(emailInputText);

        /*
         Assertions should be part of test and not part of Page object.
         Each test should be verifying one piece of functionality (atomic testing)
        */
        assertEquals(page.getEmailText(), emailInputText);
       Assert.fail("Failing test intentionally");

    }

    /**
     * Runs a simple test verifying if the comment input is functional.
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers1")
    public void verifyCommentInputTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {
        
    	//System.out.println("in test case 2");
    	String commentInputText = UUID.randomUUID().toString();

        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        driver.get("https://saucelabs.com/test/guinea-pig");

        // Navigate to the page
        SitePage page = SitePage.getPage(driver);

        /*
         enterCommentText page is an exposed "service",
             which interacts with the email input field element by sending text to it.
        */
        page.enterCommentText(commentInputText);

        /*
         Assertions should be part of test and not part of Page object.
         Each test should be verifying one piece of functionality (atomic testing)
        */
        assertEquals(commentInputText, page.getCommentText());

    }
}
