package Utility;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TestBase.Base;

public class Generic_class extends Base{
	//Generic class is for reusable: we can use classname(Generic_class).methodName(JSClick)then we have to mention the element name.
	
	public static void JSClick(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element);
	}
	//we parameterized element in the method & it returns WebElement
	
	public static List<String> DP_handle_verify(WebElement element)
	{
		List<String> mydata=new ArrayList<String>();
		Select s = new Select(element);
		List<WebElement> list = s.getOptions();
		for(WebElement ele:list)
		{
			String text = ele.getText();
			mydata.add(text);
		}
		return mydata;
	}
	public static boolean Is_equals(List<String> l1,List<String> l2)
	{
		if(l1.size()!=l2.size())
		{
			return false;
		}
		for(String s:l1)
		{
			if(!l2.contains(s))
			{
				return false;
			}
		}
		return true;
	}
	
}
