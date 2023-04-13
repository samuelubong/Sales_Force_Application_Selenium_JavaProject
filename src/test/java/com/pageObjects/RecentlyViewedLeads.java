package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;

public class RecentlyViewedLeads extends BaseClass{
	//find Create New Lead button element
			@FindBy(xpath="//div[contains(text(),'New')]")
			@CacheLookup
			WebElement createNewLeadButton;
			
			//click on Create New Lead button
			public void clickOnCreateNewLeadButton()
			{
				createNewLeadButton.click();
			}

}
