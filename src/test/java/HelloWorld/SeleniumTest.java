package HelloWorld;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import java.net.URL;

import org.junit.*;

public class SeleniumTest {

	//public static WebDriver driver;

/*	
	public void setUp() {
		try {
			System.out.println("starting selenium web driver");
			// Necesario para selenium 3 y superior
		System.setProperty("webdriver.gecko.driver", "/usr/local/etc/geckodriver");
		//	System.setProperty("webdriver.firefox.marionette","/usr/local/etc/geckodriver");
		
		//	driver = new FirefoxDriver();
			
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			// say you use the redhat5 label to indicate RHEL5 and the amd64 label to specify the architecture
	//		capability.setCapability("jenkins.label","redhat5 && amd64");
			// Say you want a specific node to thread your request, just specify the node name (it must be running a selenium configuration though)
//			capability.setCapability("jenkins.nodeName","(master)");
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4445"), capability);
	
			
		} catch (Exception ex) {
			System.err.println("Exception: " + ex.getMessage());
		}
	}

	@Test
	public void titleWebTest() {

		driver.get("http://localhost:3030/HelloWorld/");

		Assert.assertTrue(driver.getTitle().equals("Hello World!"));
	//	Assert.assertEquals(true, true);

	}

	@After
	public void close() {
		try {
			driver.close();
			driver.quit();
		} catch (Exception ex) {
			System.err.println("Exception: " + ex.getMessage());
		}
	}
	*/
	@Test
	public  void testFirefox(){
		//System.setProperty("webdriver.gecko.driver", "C:/Users/Elena Oliván/Documents/GitHub/HelloWorld-Wicket/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "/usr/local/etc/geckodriver");
		WebDriver driver= new FirefoxDriver();
		driver.get("http://localhost:3030/HelloWorld/");
		System.out.println("TITULO!!!!:"+driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().equals("Hello World!"));
		driver.close();
		//driver.quit();
		
	}
	@Test
	public  void testFirefoxFail(){
		System.setProperty("webdriver.gecko.driver", "/usr/local/etc/geckodriver");
		WebDriver driver= new FirefoxDriver();
		driver.get("http://localhost:3030/HelloWorld/");
		System.out.println("TITULO!!!!:"+driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().equals("Bye World!"));
		driver.close();
		//driver.quit();
	}
}
