package HelloWorld;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;

import java.net.URL;

import org.junit.*;

public class SeleniumTest {

	public static WebDriver driver;

	@Before
	public void setUp() {
		try {
			System.out.println("starting selenium web driver");
			// Necesario para selenium 3 y superior
		System.setProperty("webdriver.gecko.driver", "/usr/local/etc/geckodriver");
		//	System.setProperty("webdriver.firefox.marionette","/usr/local/etc/geckodriver");
		
		//	driver = new FirefoxDriver();
/*			
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			// say you use the redhat5 label to indicate RHEL5 and the amd64 label to specify the architecture
			capability.setCapability("jenkins.label","redhat5 && amd64");
			// Say you want a specific node to thread your request, just specify the node name (it must be running a selenium configuration though)
			capability.setCapability("jenkins.nodeName","(master)");
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), capability);
	*/
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", false);
			capabilities.setCapability("firefox_binary","usr/bin/firefox/");
			 driver = new FirefoxDriver(capabilities);	
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
}
