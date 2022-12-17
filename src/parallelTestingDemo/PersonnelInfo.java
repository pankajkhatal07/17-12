package parallelTestingDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonnelInfo {
	WebDriver driver;
	  @BeforeMethod
		public void login() {
			System.setProperty("webdriver.chrome.driver", "C:\\Installer\\drivers\\chromedriver.exe\\");
	         driver = new ChromeDriver();
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	         driver.manage().window().maximize();
	         driver.get("https://opensource-demo.orangehrmlive.com");
		     driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys("Admin");
		   	 driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("admin123");
		   	 driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
	     }
	  @Test
	  public void PIM() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("(//li[@class=\"oxd-main-menu-item-wrapper\"])[2]")).click();
		  Thread.sleep(3000);
		  List<WebElement>PIMmenu=driver.findElements(By.cssSelector("[class=\"oxd-topbar-body-nav-tab-item\"]"));
		  Thread.sleep(3000);
	      for(WebElement element:PIMmenu) {
	    	  if(element.isDisplayed()) {
	 			 String list = element.getText();
	 			 Thread.sleep(3000);
	 			 System.out.println(list);
	 		  }
	 		  else {
	 			  System.out.println("element is not visible");
	 		  }
	      }
	   }
	  
	  @AfterMethod
	  public void teardown() throws InterruptedException {
		  Thread.sleep(5000);
		  driver.quit();
	  }

}
