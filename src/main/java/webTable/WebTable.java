package webTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestBase.Base;

public class WebTable extends Base{

	public static List<String> Branches_table()
	{
		List<String> actualdata = new ArrayList<>();
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='DG_bankdetails']//tr[1]/td"));
		for(WebElement ele:list)
		{
			String text=ele.getText();
			System.out.println(text);
			actualdata.add(text);
		}
		return actualdata;
	}
	public static boolean isEquals_table()
	{
		List<String> actualData = Branches_table();
		List<String> expData = new ArrayList<>();
		expData.add("BranchId");expData.add("BranchName");expData.add("Address");expData.add("Area");expData.add("City");expData.add("State");expData.add("Edit");expData.add("Delet");
		
		if(!((actualData.size())==expData.size()))
		{
			return false;
		}
		for(String word:expData)
		{
			if(!actualData.contains(word))
			{
				return false;
			}
			
		}
		return true;
	}
	
	static boolean status = false;
	public static void BR_Table_Handle(String Operation, By prop, String id)
	{
		boolean flag=false;
		try
        {
        WebElement table=driver.findElement(prop);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        String[] pagelinks=rows.get(rows.size()-1).getText().split(" ");
        for(int i=1;i<pagelinks.length;i++)
        {
        try
        {
           if(pagelinks[i].contains("...") && status==true)
               {
        	   		driver.findElement(By.xpath("//a[text()='...'][2]")).click();
               }
            else
            {
                 table.findElement(By.linkText(pagelinks[i])).click();
            }
         }
         catch (Exception e)
         {
               e.printStackTrace();
         }
         if(pagelinks[i].contains("..."))
         {
        	 status=true;
             BR_Table_Handle(Operation, prop, id);
         }
         table=driver.findElement(prop);
         rows=table.findElements(By.tagName("tr"));
         for(WebElement r:rows)
         {
               List<WebElement> columns=r.findElements(By.tagName("td"));
               for(WebElement c:columns)
                {
                     if(c.getText().contains(id))
                     {
                         if(Operation.equals("edit"))
                         {
                             columns.get(columns.size()-2).findElement(By.tagName("a")).click();
                         }
                         else if(Operation.equals("delete"))
                         {
                               columns.get(columns.size()-1).findElement(By.tagName("a")).click();
                         }
                         else
                         {
                              System.out.println("Operation is Failed");
                         }
                         flag=true;
                         break;
                      }
                 }
                 if(flag==true)
                 {
                      break;
                 }
               }
                if(flag==true)
                {
                    break;
                }
        }
       
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }

	}
}
	

