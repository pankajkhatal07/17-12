package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

	
		@Test
		public void DemoTest() {
			
			Assert.assertTrue(true);
			
			System.out.println("Hello good morning");  //Pass
			
			Assert.assertEquals("Welcome", true);  //failed
			
			System.out.println("Hello");
			
			Assert.assertEquals("Selenium", "Selenium");
			
			System.out.println("Successfully passed");
			
			
		}
		@Test
		public void demoTest1() {
			System.out.println();
			Assert.assertTrue(true);	
			System.out.println("Good morning");
	        Assert.assertEquals("Selenium", "Selenium");
			
			System.out.println("Successfully passed");
		}
	}


