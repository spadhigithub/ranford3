package com.PageObject.com.ranford3;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class Admin_Page extends Base{

	public static WebElement Branches_btn()
	{
		return driver.findElement(getElement("branches"));
	}
}
