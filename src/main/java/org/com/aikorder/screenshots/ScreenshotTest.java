package org.com.aikorder.screenshots;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;
import org.com.aik.airkorder.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Ex1.Utils;

public class ScreenshotTest extends TestBase {
// static  WebDriver driver;
	public static void main(String[] args) throws IOException, Base64DecodingException {
		// TODO Auto-generated method stub
		OpenBrowser();
		//Utils.CaptureScreenshot(driver,"img.png");
	TakesScreenshot ts=(TakesScreenshot)driver;
//	we have 3 type of output type
//1. FILE and return file value
	File file=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("./Screenshots/Image1.png"));
	//2.Base 64 and return string value.convert string in to file. using file output stream writing data in to file.
	//for writing data  we need write method and write method actullay taking byte array,int array etc.
	//3. 3rd  output type is bytes
	//byte[]bytearr=ts.getScreenshotAs(OutputType.BYTES);
	// FileOutputStream fos=new FileOutputStream("./Screenshots/Image3.jpeg");
	 //fos.write(bytearr);
	 //fos.close();
//	 String  base64Code=ts.getScreenshotAs(OutputType.BASE64);
//	 byte[] bytearr=Base64.decode(base64Code);
//	 FileOutputStream fos=new FileOutputStream("./Screenshots/Image2.jpg");
//	 fos.write(bytearr);
//	 fos.close();
	 
	driver.quit();

	}

}
