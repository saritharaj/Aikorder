package org.com.air.aikorder.extentreport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	public static ExtentReports extentReports;
	private static String reportFileName = "AIK-Report" + ".html";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilepath = System.getProperty("user.dir") + fileSeperator + "TestReport";
	private static String reportFileLocation = reportFilepath + fileSeperator + reportFileName;

	public static ExtentReports setupExtentReports(){
////	SimpleDateFormat format= new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
////	Date date=new Date();
////	String actualDate=format.format(date);
//		
//	//String reportPath=System.getProperty("./TestReport/testreportext1.html");
//	ExtentReports extentReports=new ExtentReports();
//	ExtentSparkReporter SparkReporter=new ExtentSparkReporter("./TestReport/testreportext1.html");
//	extentReports.attachReporter(SparkReporter);
//	SparkReporter.config().setDocumentTitle("AIK-Automation");
//	SparkReporter.config().setReportName("Module TestCase Report");
//	SparkReporter.config().setTheme(Theme.DARK);
//	
//	
//	
//	return extentReports;
	
		String fileName = getReportPath(reportFilepath);
		ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("AIK-Automation");
		spark.config().setReportName("Regression Test Report");
		spark.config().setEncoding("utf-8");
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//		spark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.CATEGORY, ViewName.TEST,
//				ViewName.DEVICE, ViewName.EXCEPTION, ViewName.LOG, ViewName.AUTHOR }).apply();
		if (extentReports == null) {
			extentReports = new ExtentReports();
			extentReports.attachReporter(spark);
		}
		return extentReports;
	}

	// Create the report path
	private static String getReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
				return reportFileLocation;
			} else {
				System.out.println("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
		return reportFileLocation;
	
	
}
}
