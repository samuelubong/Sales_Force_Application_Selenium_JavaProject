package com.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;

public class RegisterYourMobilePhone extends BaseClass{
	//find Remind M Later Link element
			@FindBy(xpath="//a[contains(text(),'Remind Me Later')]")
			@CacheLookup
			public WebElement remindMeLaterLink;
			
			public void clickOnRemindMeLaterLink()
			{
				remindMeLaterLink.click();
			}


}
