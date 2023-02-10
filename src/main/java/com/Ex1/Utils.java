package com.Ex1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.Base64;
import org.com.aik.airkorder.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils{
	
	public static  String CaptureScreenshot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String base64Code=ts.getScreenshotAs(OutputType.BASE64);
//Below line of code will write the screenshots in to local folder
//		byte[] bytearr=Base64.decode(base64Code);
//		FileOutputStream fos=new FileOutputStream("./Screenshots/Image2.jpg");
//		 fos.write(bytearr);
//		 fos.close();
		return base64Code;
	
		//System.out.println("abc");
}
//	
//public static  String CaptureScreenshot(WebDriver driver,String fileName) throws IOException {
//		
//	TakesScreenshot ts=(TakesScreenshot)driver;
//		File file=ts.getScreenshotAs(OutputType.FILE);
//		System.out.println(driver.getTitle());
//		FileUtils.copyFile(file, new File(fileName));
//		System.out.println("abc");
////		return destFile.getAbsolutePath();
//		//FileUtils.copyFile(file, new File("./Screenshots/"+fileName+""));
//		return fileName;
//	
//		
//	}
	

}
