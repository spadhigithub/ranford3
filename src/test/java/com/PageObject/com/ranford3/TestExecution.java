package com.PageObject.com.ranford3;

import org.testng.annotations.Test;

import excel.excel_class;

public class TestExecution extends Reprository{

	@Test(priority=0)
	public void verify_launch()
	{
		Launch();
	}
	
	@Test(priority=1)
	public void verify_login()
	{
		excel_class.excelConnection("data.xls", "Sheet1");
		for(int r=1;r<excel_class.rows();r++)
		{
			String username=excel_class.readdata(0, r);
			String password=excel_class.readdata(1, r);
			login_TC(username, password);
		}
	}
	
	@Test(priority=2)
	public void branches_click()
	{
		branch_click();
	}
	
	@Test(priority=3)
	public void verify_Branches()
	{
		BranchCreation_TC();
	}
}
