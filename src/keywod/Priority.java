package keywod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Priority {
	WebDriver driver;

	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "c:\\Installer\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(priority = 4)
	public void L() {
		String Title = driver.getTitle();
		System.out.println(Title);
		System.out.println("Test6");
	}

	@Test(priority = 2) // 4
	public void C() {
		boolean b = driver.findElement(By.xpath("//div[@class=\"orangehrm-login-branding\"]")).isDisplayed();
		System.out.println(b);
		System.out.println("Test4");

	}

	@Test() // 1
	public void A() {
		driver.findElement(By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-login-forgot-header\"]")).click();
		System.out.println("Test1");
	}

	@Test() // 2
	public void B() {
		System.out.println("Test2");
	}

	@Test(priority = 3)
	public void H() {
		System.out.println("Test5");
	}

	@Test(priority = 1) // 3
	public void Z() {
		System.out.println("Test3");
	}

	@AfterMethod
	public void Teardown() throws InterruptedException { // 3 //6 //9
		Thread.sleep(3000);
		driver.quit();
	}

}
