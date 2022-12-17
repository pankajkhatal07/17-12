package parametrization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;



public class Parameterization1 {
	
	WebDriver driver;
	
	@Parameters({"URL","Username","Password"})
	@BeforeMethod
	public void login(String URL,String Username,String Password) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Installer\\drivers\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         driver.manage().window().maximize();
         Thread.sleep(3000);
         driver.get(URL);
	     driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(Username);
	   	 driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(Password);
	   	 driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
	   	}
	
	 @Parameters({"Name"})
	 @Test
	  public void Dashboard(String Name) throws InterruptedException {
		 
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		    SoftAssert  Assert =new SoftAssert();
		    String dashboard=driver.findElement(By.cssSelector("[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")).getText();
		    System.out.println(dashboard);
		    
		    String Expectedusername=Name;
		    Thread.sleep(3000);
		    String Actualusername=driver.findElement(By.cssSelector("[class=\"oxd-userdropdown-name\"]")).getText();
		    System.out.println(Actualusername);
		    if (Expectedusername.equals(Actualusername))
		    	System.out.println("Correct username");
		    else
		    	System.out.println("Incorrect username");
		    
		    Assert.assertAll();
	  }
	 
	 @AfterMethod
	 public void Teardown() throws InterruptedException {
		 Thread.sleep(3000);
		 driver.quit();
		 
	 }
	
	
	
}
