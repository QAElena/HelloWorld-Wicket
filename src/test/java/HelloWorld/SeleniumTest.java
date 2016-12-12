package HelloWorld;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;

import org.junit.*;

public class SeleniumTest {

	public static WebDriver driver;

	@Before
	public void setUp() {
		try {
			System.out.println("starting selenium web driver");
			// Necesario para selenium 3 y superior
			System.setProperty("webdriver.gecko.driver", "/usr/local/etc/geckodriver");
			driver = new FirefoxDriver();

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
