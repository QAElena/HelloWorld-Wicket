import org.openqa.selenium.firefox.FirefoxDriver;  
 import org.openqa.selenium.WebDriver;  
 public class SeleniumTest  
 {  
  public static WebDriver driver;  

  @Test
  public static void main( String[] args )  
  {  

   System.out.println("starting selenium web driver"); 
   //Necesario para selenium 3 y superior 
   System.setProperty("webdriver.gecko.driver", "/usr/local/etc/geckodriver");
   driver = new FirefoxDriver();  
   driver.get("https://www.google.com/");  

   try{  
    Thread.sleep(2000);  
   }catch(Exception e){}  

   driver.close();  
   driver.quit();  
  }  
 }  