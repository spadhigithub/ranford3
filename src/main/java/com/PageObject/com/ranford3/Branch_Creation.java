package com.PageObject.com.ranford3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class Branch_Creation extends Base{

	public static WebElement New_branches()
	{
		return driver.findElement(getElement("newBranch"));
	}
	public static WebElement BranchName_textbox()
	{
		return driver.findElement(getElement("branchName"));
	}
	public static WebElement Address1_textbox()
	{
		return driver.findElement(getElement("Address1"));
	}
	public static WebElement zipCode_textbox()
	{
		return driver.findElement(getElement("Zipcode"));
	}
	
	public static WebElement submit()
	{
		return driver.findElement(getElement("btn_insert"));
	}
}

