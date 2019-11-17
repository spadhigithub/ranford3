package com.PageObject.com.ranford3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestBase.Base;
import Utility.Generic_class;
import junit.framework.Assert;

public class Reprository extends Base{
	ExtentReports report;
	ExtentTest test;
	
	public void generate_report()
	{
		report=new ExtentReports(".\\extentreport\\report.html", true);
	}
	
	public void send_method_to_report(Method method)
	{
		test=report.startTest((this.getClass().getSimpleName()+": :"+method.getName()));
		test.assignAuthor("Santosh");
		test.assignCategory("Smoke");
	}
	public void save_report()
	{
		report.flush();
	}
	
	public void Launch()
	{
		System.setProperty("webdriver.chrome.driver", "H:\\Java_Practice\\Selenium_Softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		test.log(LogStatus.INFO, "Browser has launch");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser has maximize");
		driver.get(GetConfig("Build1"));
		test.log(LogStatus.INFO, "Navigated to URL");
		String ActualUrl=driver.getCurrentUrl();
		try{
			org.testng.Assert.assertEquals(ActualUrl, GetConfig("Build1"));
			Assert.assertTrue("Launch is Success", ActualUrl.equals(GetConfig("Build1")));
			test.log(LogStatus.PASS, "My expUrl :-"+GetConfig("Build1")+" is matching with my actualURL");
			test.log(LogStatus.INFO, "Launch is done Successfully");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "My ExpUrl :-" +GetConfig("Build1")+" is not matching with my actual URL");
			test.log(LogStatus.INFO, "404 Error");
			Assert.fail("Page is not loaded :- "+e.getMessage());
		}
		
		//driver.manage().deleteAllCookies();
		//To delete all cookies
	}
	public void login_TC(String username, String password)
	{
		LoginPage.Username_editbox().sendKeys(GetConfig("username"));
		LoginPage.password_editbox().sendKeys(GetConfig("password"));
		Generic_class.JSClick(LoginPage.login());
	}
	
	public void branch_click()
	{
		Assert.assertTrue(Admin_Page.Branches_btn().isDisplayed());
		Generic_class.JSClick(Admin_Page.Branches_btn());
	}
	
	public void BranchCreation_TC()
	{
		Assert.assertTrue(Branch_Creation.New_branches().isDisplayed());
		Generic_class.JSClick(Branch_Creation.New_branches());
		
		Branch_Creation.BranchName_textbox().sendKeys(GetConfig("branchName"));
		Branch_Creation.Address1_textbox().sendKeys(GetConfig("Address1"));
		Branch_Creation.zipCode_textbox().sendKeys(GetConfig("Zipcode"));
		
		Assert.assertTrue(Branch_Creation.submit().isDisplayed());
		Generic_class.JSClick(Branch_Creation.submit());	
	}
	
}