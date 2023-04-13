package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;

public class HomePage extends BaseClass{
	public WebDriver ldriver;
	SoftAssert softassert = new SoftAssert();
	public HomePage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	        //find Lead tab element
			@FindBy(xpath="//a[@class='slds-context-bar__label-action dndItem'][@title='Leads']")
			@CacheLookup
			WebElement leadTab;
			
			//find Account tab element
			@FindBy(xpath="//a[@class='slds-context-bar__label-action dndItem'][@title='Accounts']")
			@CacheLookup
		    WebElement AccountTab;
			
			//find Contact tab element
			@FindBy(xpath="//a[@class='slds-context-bar__label-action dndItem'][@title='Contacts']")
			@CacheLookup
			WebElement ContactTab;
			
			//find Opportunity tab element
	        @FindBy(xpath="//a[@class='slds-context-bar__label-action dndItem'][@title='Opportunities']\r\n"
			+ "")
	        @CacheLookup
			WebElement OpportunityTab;
	        
	        //find Home tab element
	        @FindBy(xpath="//a[@class='slds-context-bar__label-action dndItem'][@title='Home']")
	        @CacheLookup
	      	WebElement HomeTab;
			
	        //find Setup button element
	        @FindBy(xpath="//a[@role='button'][@data-aura-rendered-by='154:217;a']")
	        @CacheLookup
	      	WebElement SetupButton;
			
			//click on Lead tab
			public void clickOnLeadTab()
			{
				leadTab.click();
			}
			
			//click on Account tab
			public void clickOnAccountTab()
			{
				AccountTab.click();
			}
			
			//click on Contact tab
			public void clickOnContactTab()
			{
				ContactTab.click();
			}
			
			//click on Opportunity tab
			public void clickOnOpportunityTab()
			{
				OpportunityTab.click();
			}
			
			//click on Setup button
			public void clickOnSetupButton()
			{
				SetupButton.click();
			}
}
