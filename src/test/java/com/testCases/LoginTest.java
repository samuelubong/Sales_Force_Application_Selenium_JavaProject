package com.testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test(priority=1)
	public void Logintest() throws IOException
	{
		//Started the login test
		logger.info("Started Logintest");
		//Create an object for LoginPage
		logger.info("Attempting valid user login into Salesforce Sandbox");
		LoginPage loginpg = new LoginPage(driver);
		loginpg.enterUsername(username);		//Pass username1 declared in config file
		loginpg.enterPassword(password);	//Pass password declared in config file
		loginpg.clickLoginToSandboxButton();             //Click on submit button
		
		//Validate whether login is successful
		SoftAssert softassert = new SoftAssert();
		if(driver.getTitle().equals("Register Your Mobile Phone | Salesforce"))
		{
			softassert.assertTrue(true);
			logger.info("Test Passed! Login Successful!");
		}
		else
		{
			softassert.assertTrue(false);
			logger.info("Test Failed! Login failed!");
			captureScreen(driver,"Logintest");
		}
		softassert.assertAll();
		logger.info("Completed Logintest");
		
	}
	
}
