package org.com.air.aikorder.extentreport;

import java.io.IOException;

import org.com.aik.airkorder.TestBase;
import org.openqa.selenium.WebDriver;

import com.Ex1.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter6 extends TestBase {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("./Report/Report3.html");
		extentReports.attachReporter(extentSparkReporter);
		OpenBrowser();
		//Utils.CaptureScreenshot(driver,"test.png");
		String base64Code = Utils.CaptureScreenshot(driver);
		extentReports
		.createTest("Screenshot test1", "This is for attaching the screenshots at test level")
		.info("This is info messag")
		//.addScreenCaptureFromPath("./Screenshots/test.png");
		.addScreenCaptureFromBase64String(base64Code)
		.addScreenCaptureFromBase64String(base64Code,"AIK Home Page");
		//Fail have 4 overloaded method>1.media entity,2. string_media entity 3
		extentReports
		.createTest("Screenshot test7","This is for attaching the screenshots at log level")
		.info("This is info messag")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"AIK Home Page1").build());
		
		extentReports
		.createTest("Screenshot test8","This is for attaching the screenshots at log level-.fail method type2>string+media entitybuilder")
		.info("This is info messag")
		.fail("Thi is info measge",MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Title below the image").build());		
		extentReports.flush();
		
		
		Throwable t=new Throwable("This is throwable exception");
		extentReports
		.createTest("Screenshot test9","This is for attaching the screenshots at log level-.fail method type2>string+media entitybuilder")
		.info("This is info messag")
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code,"Title below the image").build());		
		extentReports.flush();

	}

}
