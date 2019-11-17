package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.bytebuddy.jar.asm.commons.LocalVariablesSorter;

public class Base {

	static Properties p;
	public static WebDriver driver;
	
	public static void LoadProperty()
	{
		try {
			File f = new File(".\\src\\main\\java\\Configuration\\OR.properties");
			//path of the file
			FileReader r = new FileReader(f);
			//Read the file
			p = new Properties();
			
			p.load(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
		public static By getElement(String key)
		{
			LoadProperty();
			By loc=null;
			String value=  p.getProperty(key);
			String loctype= value.split(":")[0];
			//we need to split the value as per the index value from OR.properties
			String locValue= value.split(":")[1];
			
			//we need to give all the element locators as per the id, name, xpath..may be tomorrow it might be id so we have to create it in sw
			switch(loctype)
			{
			case "name":
				loc= By.name(locValue);
				break;
			case "id":
				loc= By.id(locValue);
				break;
			case "xpath":
				loc= By.xpath(locValue);
				break;
			case "cssSelector":
				loc= By.cssSelector(locValue);
				break;
			}
			return loc;
		}
		public static void loadpropertyconfig()
		{
			try 
			{
				File f = new File(".\\src\\main\\java\\Configuration\\Config.properties");
				FileReader fr = new FileReader(f);
				p=new Properties();
				p.load(fr);
			} 	catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		public static String GetConfig(String key)
		{
				loadpropertyconfig();
				String data = p.getProperty(key);
				return data;
		}
			
	}