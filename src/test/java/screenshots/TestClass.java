package screenshots;

import static org.testng.Assert.assertEquals;


import java.io.IOException;

import org.com.air.aikorder.extentreport.ExtentFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//@Listeners(ITestListenerClass.class)---we can define listeners at class level and suite level
//@Listeners({ITestListenerClass.class,ITestListenerClass.class})--if you have multiple listener class then, you need to pass the listener class name in curly bracket with comma seperarted.
public class TestClass  extends BaseTest{
	@Test
	public void TestGoogle() throws InterruptedException, IOException {
		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials");
		String expectedTitle="hyr tutorials - Google Search";
		String actualTitle=driver.getTitle();
		assertEquals(actualTitle, expectedTitle,"Title is matching");
	
	}
	
	@Test
	public void TestFacebook() throws IOException {
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("");
		SoftAssert softAssert=new SoftAssert();
		//Title Assertion
		String actualTitle=driver.getTitle();
		String ExpectedTitle="Facebook – log in or sign up";
		softAssert.assertEquals(actualTitle, ExpectedTitle,"Title is matching");
		//CaptureScreenshot("img2.jpg");
		
	}


}
