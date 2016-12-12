package HelloWorld;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.By;				
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;

public class SeleniumTest {

	public static WebDriver driver; 
	@BeforeTest
	public void setUp()
	{
		try
		{
		driver = new FirefoxDriver();
		}catch(Exception ex)
		{
			System.err.println("Exception: "+ex.getMessage());
		}
	}
	
	@Test
	public void titleWebTest()
	{
	   System.out.println("starting selenium web driver"); 
	   //Necesario para selenium 3 y superior 
	   System.setProperty("webdriver.gecko.driver", "/usr/local/etc/geckodriver");
	   driver = new FirefoxDriver();  
	   driver.get("http://localhost:3030/HelloWorld/");  
	 
	   Assert.assertTrue(driver.getTitle().equals("Hello World!")); 	
	   try{  
	    Thread.sleep(2000);  
	   }catch(Exception e){}  


	}
	
	@AfterTest
	public void close(){
			try
			{
			   driver.close();  
			   driver.quit();
			}catch(Exception ex)
			{
				System.err.println("Exception: "+ex.getMessage());
			}
		}
}
