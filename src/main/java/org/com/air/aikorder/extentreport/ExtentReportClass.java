package org.com.air.aikorder.extentreport;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {
//create the object for ExtentReports class.its like main class like report engine for extent reports under extent report.
//we have so many type of reports. you can create spark report, email reporter. based on the report we need to create another object.
//here we are going to create spark reporter, its open source.if you create the reporter object you need to pass the file path 
// reporter object should be attach with  engine(ExtentReports)
	public static void main(String[]args) {
	ExtentReports extentReports=new ExtentReports();
	ExtentSparkReporter SparkReporter=new ExtentSparkReporter("./TestReport/report.html");
	//File file=new File("report.html");
	//ExtentSparkReporter SparkReporter=new ExtentSparkReporter("file");
	//ExtentSparkReporter SparkReporter=new ExtentSparkReporter("./TestReport/report.html");
	extentReports.attachReporter(SparkReporter);
	ExtentTest test1=extentReports.createTest("Test1");
	//if you need to identify the  status of test1, we have two method, one is log method and another is directly the status method
	test1.pass("This is passed");
	ExtentTest test2=extentReports.createTest("Test2");
	test2.log(Status.FAIL, "This is failed");
	ExtentTest test3=extentReports.createTest("Test3").skip("This is skipped");
	extentReports.flush();
	

}
}