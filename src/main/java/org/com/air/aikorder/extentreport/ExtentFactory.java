package org.com.air.aikorder.extentreport;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
	//static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extentReports = ExtentReportNG.setupExtentReports();
	
	public static synchronized ExtentTest getTest() {
		//To return ExtentTest instance in TestListiner or test classes
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}
	
	public static synchronized void endTest() {
		extentReports.flush();
	}
	
	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		//System.out.println(test);
		return test;
	}


}
