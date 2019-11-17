package com.PageObject.com.ranford3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class LoginPage extends Base{

	public static WebElement Username_editbox()
	{
		return driver.findElement(getElement("username"));
	}
	public static WebElement password_editbox()
	{
		return driver.findElement(getElement("password"));
	}
	public static WebElement login()
	{
		return driver.findElement(getElement("login"));
	}
	
	
	
	/*public void logout(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id='Table_02']/tbody/tr/td[3]/a/img"));
	}*/
}
