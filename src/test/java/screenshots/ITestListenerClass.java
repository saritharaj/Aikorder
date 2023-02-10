package screenshots;

import java.io.IOException;

import org.com.air.aikorder.extentreport.ExtentFactory;
import org.com.air.aikorder.extentreport.ExtentReportNG;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


//In ITestListener we have some method called onTestSuccess and  onTestFailure.
//When ever there is a failure for test, there will be some  event will happen and triggered internally
//and that event will be listerned by testng and this method will be executed.
//right click>source>overideimplementmethod
public class ITestListenerClass extends BaseTest implements ITestListener {
	
	@Override
	public void onStart(ITestContext iTestContext) {
		iTestContext.getName();
	}
	
	@Override
	public void onFinish(ITestContext context) {
		ExtentFactory.endTest();
		ExtentReportNG.setupExtentReports().flush();
		}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.startTest(result.getMethod().getMethodName());
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getTest().log(Status.PASS,MarkupHelper.createLabel("TestPassed",ExtentColor.GREEN)) ;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
//		try {
//			
//			CaptureScreenshot(result.getMethod().getMethodName()+".jpg");
////			CaptureScreenshot("test.jpg");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		//WebDriver webDriver=BaseTest.getDriver();
		//System.out.println(driver);
	String base64Screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	//String base64Screenshot = "data:image/png;base64,"
		//	+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	//System.out.println("base64Screenshot :"+base64Screenshot);
		//ExtentFactory.startTest("Sampe Test");
		System.out.println("Sample Test");
		ExtentFactory.getTest().log(Status.FAIL,"Test Failed,Error Log:-"+result.getThrowable());
		//System.out.println("Sample Test 1 ");
		ExtentFactory.getTest().log(Status.INFO,"Error Screenshot",MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
//		
	}

	

	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

//	

	
	

	
		
	
	

}
