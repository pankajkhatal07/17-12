package parallelTestingDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dashboard1 {
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
	public void Dashboard() throws InterruptedException {

		String dashboard = driver
				.findElement(By.cssSelector("[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]"))
				.getText();
		System.out.println(dashboard);

		String Expectedusername = "Paul Collings";
		Thread.sleep(3000);
		String Actualusername = driver.findElement(By.cssSelector("[class=\"oxd-userdropdown-name\"]")).getText();
		System.out.println(Actualusername);
		if (Expectedusername.equals(Actualusername))
			System.out.println("Correct username");
		else
			System.out.println("Incorrect username");
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
