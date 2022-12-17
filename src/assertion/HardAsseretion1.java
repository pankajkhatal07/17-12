package assertion;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class HardAsseretion1 {
	WebDriver driver ;
	@BeforeMethod
	public void Setup() {
	//chrome driver
		//System.setProperty("webdriver.chrome.driver", "C:\\Installer\\drivers\\chromedriver.exe\\");
       // driver = new ChromeDriver();
		
	//edge driver	
//        System.setProperty("webdriver.edge.driver", "C:\\Installer\\drivers\\msedgedriver.exe");
//        driver = new EdgeDriver();
     //firefox driver 
//        System.setProperty("webdriver.gecko.driver", "C:\\Installer\\drivers\\geckodriver.exe");
       driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	}
	
	@Test(priority =1)
	public void Username() throws InterruptedException {
		
		WebElement Username=driver.findElement(By.cssSelector("[name=\"username\"]"));
		
		WebElement Password=driver.findElement(By.cssSelector("[name=\"password\"]"));
	    WebElement logo = driver.findElement(By.cssSelector("[alt=\"company-branding\"]"));
	    Thread.sleep(3000);
       boolean lmessage= logo.isDisplayed();
       System.out.println(lmessage);
		//Assert.assertTrue(lmessage);
       
		Assert.assertTrue(lmessage);
		Thread.sleep(3000);
		Assert.assertTrue(Username.isDisplayed());
		Username.sendKeys("Admin");
		Thread.sleep(3000);
		
		Assert.assertTrue(Password.isDisplayed());
		Password.sendKeys("admin123");
//		
		//Assertfalse
//       Assert.assertFalse(lmessage);
//		Assert.assertFalse(Username.isDisplayed());
//		Username.sendKeys("Admin");
//		Thread.sleep(3000);
//		
//		Assert.assertFalse(Password.isDisplayed());
//		Password.sendKeys("admin123");
		
	}
	//Assertequal
	@Test(priority=2)
	public void orangeHRm() throws InterruptedException {
		
	Thread.sleep(3000);
	boolean text=driver.findElement(By.xpath("//input[@name=\"username\"]")).isDisplayed();
	Assert.assertTrue(text);
	Assert.assertEquals(text, true);
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	
}
