package testNGPractical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParkFinda {
  
	//Global variable Decleration
	public String  baseURL="https://parkfinda.com/";
	public String driverpath="C:\\Users\\Janaka Sajith\\eclipse-workspace\\SQA_Batch26_Pom_and_Factory\\Thirdparty_Resource_Files\\Chrome Driver\\V119.exe";
	public WebDriver driver;
	public String actualtext;
	public String expectedtext;
	public boolean status;
	
	@BeforeTest
	public void BeforeTest() {
		System.setProperty("Webdriver.chrome.driver", driverpath);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	//Test case section
	@Test(priority=1)
	public void LoginSystem() throws  InterruptedException{
		
		System.out.println("-------------TC 001----------------");
		
		//Userlogin();
		UsernameLogin();
	}
	/*@Test(priority=1)
	public void Signin() throws InterruptedException {
		System.out.println("-------------TC002-----------------");
		
		SignIN();
		
	}*/
		
	//supportive method Section
	/*public void Userlogin() throws InterruptedException {
		
		driver.get(baseURL);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/nav/div[1]/div[3]/a[1]")).click();
		
		
	}*/
	public void UsernameLogin() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/nav/div[1]/div[3]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"Username\"]")).sendKeys("janakasajithpriya@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Janaka@22");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/form/div[4]/button")).click();
		
		Thread.sleep(4000);
		
	}
	
	/*public void SignIN() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/nav/div[1]/div[3]/a[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"First Name\"]")).sendKeys("Janaka");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"Last Name\"]")).sendKeys("Sajith");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"Username\"]")).sendKeys("janakasajithpriya@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"Mobile Number\"]")).sendKeys("76786812");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Janaka@22");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"Confirm Password\"]")).sendKeys("Janaka@22");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/form/div[5]/button")).click();
		Thread.sleep(3000);
		
		
		
	}*/

	public void BookingSearch() throws InterruptedException {
		driver.get(baseURL);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/section[1]/section/div/div/div[3]/div/div/div/div[1]")).sendKeys("beyonne");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/section[1]/section/div/div/div[5]/div/button")).click();
		Thread.sleep(2000);
	}
	

	
}
