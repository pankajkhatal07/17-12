package assertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {


	SoftAssert soft =new SoftAssert();
	
	@Test
	public void DemoTest1() {
	
		soft.assertEquals("Welcome", "Welcome");
		System.out.println("Execution Started");
		
		soft.assertEquals("Selenium", "Seleniu");  //false
		
		System.out.println("Successfully passed DemoTest");
			
		soft.assertAll();// collect all exception
		
//It collect the result of all the assertion and in case of any failure mark the test as failed
	}
	@Test
	public void DemoTest2() {
		soft.assertEquals("Welcome", "Welcome");  //True
		System.out.println("Execution Started 2");
				
		soft.assertTrue(true);
		
		//soft.assertEquals(false,false);  //false
		
        soft.assertEquals("Selenium", "Selenium");  
		
		System.out.println("Successfully passed DemoTest 2");
		
		//soft.assertAll();
	}
	
	
}
