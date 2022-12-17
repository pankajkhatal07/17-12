package parallelTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ParallelTesting1 {
	WebDriver driver;

	@BeforeMethod

	public void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Installer\\drivers\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("admin123", Keys.ENTER);
		// driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
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

	@Test
	public void admin() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("li.oxd-main-menu-item-wrapper")).click();
		Thread.sleep(3000);
		List<WebElement> menutab = driver.findElements(By.cssSelector("[class=\"oxd-topbar-body-nav-tab-item\"]"));
		Thread.sleep(3000);
		for (WebElement element : menutab) {
			if (element.isDisplayed()) {
				String list = element.getText();
				Thread.sleep(3000);
				System.out.println(list);
			} else {
				System.out.println("element is not visible");
			}

		}

	}

	@Test
	public void PIM() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@class=\"oxd-main-menu-item-wrapper\"])[2]")).click();
		Thread.sleep(3000);
		List<WebElement> PIMmenu = driver.findElements(By.cssSelector("[class=\"oxd-topbar-body-nav-tab-item\"]"));
		Thread.sleep(3000);
		for (WebElement element : PIMmenu) {
			if (element.isDisplayed()) {
				String list = element.getText();
				Thread.sleep(3000);
				System.out.println(list);
			} else {
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
