package org.com.air.aikorder.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter4 {
//log events are 5 type INFO,PASS,FAIL,WARNING,SKIP, here priority level should be fail,skip,warning,pass,info
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentReports extentReports=new ExtentReports();
		ExtentSparkReporter extentSparkrReporter=new ExtentSparkReporter("./TestReport/testreport1.html");
		extentReports.attachReporter(extentSparkrReporter);
		
		extentReports
		.createTest("Test 1")
		.log(Status.INFO, "<b><i>info1</i></b>")
		.log(Status.PASS,"pass")
		//.log(Status.FAIL,"fail")
		.log(Status.SKIP,"skiping")
		.log(Status.WARNING,"warning");
		extentReports
		.createTest("create label test")
		.info(MarkupHelper.createLabel("this is a highlighted meaasga", ExtentColor.RED));
		
		try {
			int i=5/0;
		}
		catch(Exception e) {
			extentReports
			.createTest("Exception test1")
			.info(e);
		
			
			
			
			
		}
		
		//here   overl all test status should be skip, becoze here fail staus is not presentb.so skip should come first
		extentReports.flush();
		

	}

}
