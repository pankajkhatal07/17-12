package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataprovider {

	WebDriver driver;

	@Test(dataProvider = "LoginData")
//	public void login(String Username,String Password) throws InterruptedException {
//		 System.setProperty("webdriver.chrome.driver", "C:\\Installer\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
//        Thread.sleep(3000);
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	     driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(Username);
//	   	 driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(Password);
//	   	 driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
//	   	 Thread.sleep(3000);
//	   	 driver.quit();
	public void login(String[] s) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Installer\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(s[0]);
		driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(s[1]);
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.quit();
	}

	@DataProvider(name = "LoginData", indices = { 0, 2 })
	public Object[][] loginData() {

		Object credential[][] = { { "Admin", "admin123" }, { "Admin", "admin" }, { "admin", "admin123" },
				{ "admin", "Admin12" } };
		return credential;
	}

}
