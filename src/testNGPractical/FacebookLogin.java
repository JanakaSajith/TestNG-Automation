package testNGPractical;
import java.io.File;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import ch.qos.logback.core.util.FileUtil;

import ch.qos.logback.core.util.FileUtil;
//import org.apache.commons.io.FileUtils;
public class FacebookLogin {
	
	//Global variable declaration
	public String baseURL="https://web.facebook.com/login/?_rdc=1&_rdr";
	public String driverPath="C:\\Users\\Janaka Sajith\\eclipse-workspace\\SQA_Batch26_Pom_and_Factory\\Thirdparty_Resource_Files\\Chrome Driver\\V119.exe";
	public WebDriver driver;
		
	//Before test
	@BeforeTest
	public void beforeTestExecution()
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
		
	//Test case/s
	@Test
	public void FacebookLoginFunction() throws Exception
	{
		WebElement userNametxt = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement passwordtxt = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		WebElement loginbtn = driver.findElement(By.name("login"));
		
		userNametxt.sendKeys("Nadun");
		passwordtxt.sendKeys("12345");
		loginbtn.click();
		
		Thread.sleep(5000);
		
		//this.takeSnapShot(driver, "C:\\Users\\user\\Desktop\\SS\\Facebook Login Error.png");
		
	}
		
	//After test
	@AfterTest
	public void AfterTestExecutionProcess()
	{
		//driver.quit();
	}
  
	//Additional Methods
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		  
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		  
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		  
		//Copy file at destination
		//FileUtil.copy(SrcFile, DestFile);
		Files.copy(SrcFile, DestFile);
	}

}
