package annotations;

import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;

public class Annotation1 {
	
	// in real time project  we don't need all these annotations
		//we used only @beforeclass @beforemethod @afterclass @Aftermetho @Test
		
		
	   //Precondition annotation  -- Starts with @before
		
		/*@BeforeSuite --Set up property for chrom    - 1st preference
		@BeforeTest --Enter URL                       - 2nd 
		@BeforeClass -- LaunchBrowser                 - 3rd
		
		@BeforeMethod --Loin to application   //1
		@Test-- google Test
		@AfterMethod--Logout from application
		
		@BeforeMethod --Loin to application
		@Test--demo Test
		@AfterMethod--Logout from application
		
		
		@AfterClass-- clsoe browser               
		@AfterTest --deleteallcookies
		@Aftersuite
		*/
		@BeforeClass
		public void LaunchBrowser() {
			System.out.println("@BeforeClass -- LaunchBrowser");
		}
		@BeforeTest
		public void URL() {
			System.out.println("@BeforeTest --Enter URL");
		}
		@BeforeMethod
		public void login() {
			System.out.println("@BeforeMethod --Loin to application");
		}	
		//Test ann - starts with @Test
		@Test
		public void GoogletitleTest() {
			System.out.println("@Test-- google Test");
		}
		@Test
		public void  demo() {
			System.out.println("@Test--demo Test");
		}
		@Test
		public void  demo2() {
			System.out.println("@Test--demo2 Test");
		}
		
		//Postcondition -starts with @After 
		@AfterMethod
		public void logout() {
			System.out.println("@AfterMethod--Logout from application");
		}
		@AfterClass
		public void closebrowser() {
			System.out.println("@AfterClass-- clsoe browser");
		}
		@AfterTest
		public void deleteallcookies() {
			System.out.println("@AfterTest --deleteallcookies");
		}
		@BeforeSuite
		public void Setup() {
			System.out.println("@BeforeSuite --Set up property for chrom");
		}

	
	
	
	

}
