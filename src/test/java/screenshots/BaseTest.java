package screenshots;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	@BeforeTest
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\airkorder\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
//	public static WebDriver getDriver() {
//		return driver;
//		
//	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
//	public static  String CaptureScreenshot(WebDriver driver,String fileName) throws IOException {
//		
//		TakesScreenshot ts=(TakesScreenshot)driver;
//			File file=ts.getScreenshotAs(OutputType.FILE);
//			System.out.println(driver.getTitle());
//			FileUtils.copyFile(file, new File(fileName));
//			//System.out.println("abc");
////			return destFile.getAbsolutePath();
//			FileUtils.copyFile(file, new File("./Screenshots/"+fileName+""));
//			return fileName;
//		
//			
//		}
//	public static void CaptureScreenshot(String fileName) throws IOException {
//		if(screenshotsSubFolderName == null) {
//			LocalDateTime myDateObj = LocalDateTime.now();
//			 System.out.println("Before formatting: " + myDateObj);
//		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
//		    String screenshotsSubFolderName = myDateObj.format(myFormatObj);
//		    System.out.println("After formatting: " + screenshotsSubFolderName);
//		    }
//		
//		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File destFile = new File("./Screenshots/"+screenshotsSubFolderName+"/"+fileName);
//		FileUtils.copyFile(sourceFile, destFile);
//		System.out.println("Screenshot saved successfully");
//	}

	
//	public static String  CaptureScreenshot(WebDriver driver) {
////		String base64Screenshot = "data:image/png;base64,"
////				+ ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
////		return base64Screenshot;
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		String base64Screenshot=ts.getScreenshotAs(OutputType.BASE64);
////		byte[] bytearr=Base64.Decoder(base64Screenshot);
////		FileOutputStream fos=new FileOutputStream("./Screenshots/Image2.jpg");
////		 fos.write(bytearr);
////		 fos.close();
//		return base64Screenshot;
//	}
}
