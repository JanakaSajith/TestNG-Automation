package testNGPractical;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminUserSearch {
  
	 //Global Variables section
	 public String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	 public String driverpath="C:\\Users\\Janaka Sajith\\eclipse-workspace\\SQA_Batch26_Pom_and_Factory\\Thirdparty_Resource_Files\\Chrome Driver\\V119.exe";
	 public WebDriver driver;
	 public String expectedtext;
	 public String actualtext;
	 public boolean status;
		
	  @BeforeTest
	  public void beforeTest() {
		  
		  //Set system properties for the Chrome Browser
		  System.setProperty("webdriver.chrome.driver", driverpath);			

		  //Define the Web Driver
		  driver = new ChromeDriver();			  

		  //Call the chrome browser and maximize in the Desktop
		  driver.manage().window().maximize();
	  
	  }
	  
	  
	  //Test Case Section
	  
	  //Test Case - Search by User Name (TC: 001)
	  @Test (priority = 1)
	  public void searchByUsername() throws Exception {
		  
		System.out.println("---------------TC 001---------------");
		  
		  //Login to the system
		  userLogin();
		
		  //Select Admin sub menu item
		  adminClick();
		
		  //send the username 
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Admin");
		  
		  //click the search button
		  searchButtonClick();
		  
		  Thread.sleep(4000);
		  //Verify if the filter result is correct
		  expectedtext="Admin";
		  actualtext = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText();
		  
		  //Print actual text
		  System.out.println("Test Case 001 Actual Text: "+actualtext);
		  
		  if (expectedtext.equals(actualtext))
		   {
			     System.out.println("TC 007: PASS");
		         System.out.println("Admin search for system user by username is done successfully");
		         System.out.println("TC 007: Screen Image Captured - Success");
		         this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\error.png");
		   } 
		   else 
		   {
			   System.out.println("TC 007: FAIL");
			   System.out.println("TC 007: Screen Image Captured - Fail");
			   this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\error2.png");
			   
		   }
		  
		System.out.println("------------------------------------");  
		
		//Click reset button
		restbuttonClick();
		
	  }
	  
	  //Test Case - Search By Existing User Name (TC: 008)
	  @Test (priority = 2)
	  public void searchByNonExistingUsername() throws Exception {
		  
		  restbuttonClick();
		  
		  System.out.println("---------------TC 002---------------");
		
		  //send the user name 
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Janaka");

		  //click the search button
		  searchButtonClick();
		  
		  //Verify if the filter result is correct
		  expectedtext="No Records Found";
		  actualtext = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText();	  
		  if (expectedtext.equals(actualtext))
		   {
			     System.out.println("TC 002: PASS");
		         System.out.println("Admin search for system non existing user by username is done successfully");
		         this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\SearchByUsernameError.png");
		   } 
		   else 
		   {
			   System.out.println("TC 002: FAIL");
			   System.out.println("TC 008: Screen Image Captured");
			   this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\SearchByNonExistingUsernameError.png");
		   }
		System.out.println("------------------------------------");  
		
		//Click reset button
		restbuttonClick();
	  }
	  
	  //Search By UserRole (TC: 009)
	  @Test (priority = 3)
	  public void searchByUserRole() throws InterruptedException {
		  System.out.println("---------------TC 009---------------");
		
		 //User role drop down filtering
		  userRoleDropDownFilterSelection();
		  
		  //click the search button
		  searchButtonClick();
		  
		//Verify if the filter result is correct
		  expectedtext="Admin";
		  actualtext = driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[3]")).getText();	  
		  if (expectedtext.equals(actualtext))
		   {
			     System.out.println("TC 009: PASS");
		         System.out.println("Admin search for system user by user role is done successfully");
		   } 
		   else 
		   {
			     System.out.println("TC 009: FAIL");
		   }
		System.out.println("------------------------------------");  
		
		//Click reset button
		resetButtonClick();
	  }
	  
	  //Search By Employee Name (TC: 010)
	  @Test (priority = 4)
	  public void searchByEmployeeName() throws InterruptedException {
		  System.out.println("---------------TC 010---------------");
		
		  //employee name filtering
		  employeeNameEnter();
		  
		  //click the search button
		  searchButtonClick();
		  
			//Verify if the filter result is correct
		  expectedtext="John Smith";
		  actualtext = driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[4]")).getText();	  
		  if (expectedtext.equals(actualtext))
		   {
			     System.out.println("TC 010: PASS");
		         System.out.println("Admin search for system user by employee name is done successfully");
		   } 
		   else 
		   {
			     System.out.println("TC 010: FAIL");
		   }
		System.out.println("------------------------------------");  
		
		//Click reset button
		resetButtonClick();
	  }
	  
	  //Search By Status (TC: 011)
	  @Test (priority = 5)
	  public void searchByStatus() throws InterruptedException {
		  System.out.println("---------------TC 011---------------");
		
		  //select status
		  statusDropDownFilterSelection();
		  
		  //click the search button
		  searchButtonClick();
		  
			//Verify if the filter result is correct
		  expectedtext="Enabled";
		  actualtext = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[5]/div")).getText();	  
		  if (expectedtext.equals(actualtext))
		   {
			     System.out.println("TC 011: PASS");
		         System.out.println("Admin search for system user by status is done successfully");
		   } 
		   else 
		   {
			     System.out.println("TC 011: FAIL");
		   }
		System.out.println("------------------------------------");  
		
		//Click reset button
		resetButtonClick();
	  } 
	  
	  //Reset Search Filter And Results (TC: 012)
	  @Test (priority = 6)
	  public void resetSearchFilterAndResults() throws InterruptedException {
		  System.out.println("---------------TC 012---------------");
		
		//send the username 
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("John.Smith");

		//user role filtering
		  userRoleDropDownFilterSelection();
		  
		//employee name filtering
		  employeeNameEnter();
		  
		//status filtering
		  statusDropDownFilterSelection();
		  
		  //click the search button
		  searchButtonClick();
		  
		  //Click reset button
		  resetButtonClick();
		  
			//Verify if the reset result is correct
		  expectedtext="-- Select --";
		  actualtext = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).getText();	  
		  if (expectedtext.equals(actualtext))
		   {
			     System.out.println("TC 012: PASS");
		         System.out.println("Reset button click to reset search filtering and filtered results is done successfully");
		   } 
		   else 
		   {
			     System.out.println("TC 012: FAIL");
		   }
		System.out.println("------------------------------------");  
	  } 
	  
	  @AfterTest
	  public void afterTest() throws InterruptedException {
			//Wait for 3 seconds till the page loads
			Thread.sleep(3000);
			//quit the browser
			driver.quit();
	  }
	  
	  
	  //Supportive Methods Section
	  
	  public void userLogin() throws InterruptedException {
	
		  //Go to Orange HRM URL
		  driver.get(baseURL);
		  
		  //Wait for 3 seconds till the page loads
		  Thread.sleep(3000);
		  
		  //send the login username and password
		  
		  driver.findElement(By.name("username")).sendKeys("Admin");
		  driver.findElement(By.name("password")).sendKeys("admin123");
		  
		  //Wait for 3 seconds till the page loads
		  Thread.sleep(3000);
		  
		  //Click login button
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		  //Wait for 5 seconds till the page loads
		  Thread.sleep(5000);
	}
	  
 	  public void adminClick() throws InterruptedException {
		  
		  //click Admin menu item
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
		  
		  //Wait for 3 seconds till the page loads
		  Thread.sleep(3000);
		  
		  //Verify if the Admin menu is clicked successfully
		  expectedtext="System Users";
		  actualtext= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).getText();
		  
		  //wait 3 seconds until the Browser loading
		  Thread.sleep(3000);
		 
		  if(expectedtext.equals(actualtext)) {
			  System.out.println("User log in to the admin sub menu successfully");
			  
		  }
		  else {
			  System.out.println("Unsuccessfully logging to the admin menu");
		  }
		  
		
	  }
	  
 	  public void restbuttonClick() throws InterruptedException{
 		  
 		  //click on the reset button
 		  driver.findElement(By.xpath("//*[@id=\"app\"]")).click();
 		  
 		  //wait 5 seconds until the page loading
 		  Thread.sleep(4000);
 	  }
 	  

 	  public void searchButtonClick() throws InterruptedException {
			
		  //click the search button
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
		  
		  //Wait for 5 seconds till the page loads
		  Thread.sleep(5000);
	  }

	  public void userRoleDropDownFilterSelection() throws InterruptedException {
			//click the drop down arrow under User Role
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")).click();

			  //Wait for 1 second till the drop down loads
			  Thread.sleep(1000);
			  
			  //select the Admin option
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]")).click();
			  
			  //Wait for 1 second till Admin option is selected
			  Thread.sleep(1000);
		  }
	  
	  public void employeeNameEnter() throws InterruptedException {
			//enter employee name
		  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")).sendKeys("John S");
		  
		  //Wait for 2 seconds till the drop down loads
		  Thread.sleep(2000);
		  
		  //select the name suggestion
		  driver.findElement(By.xpath("	//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div")).click();
		  //Wait for 2 seconds till suggested name is selected
		  Thread.sleep(2000);  
	  }

	  public void statusDropDownFilterSelection() throws InterruptedException {
			//click the drop down arrow under Status
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i")).click();

			  //Wait for 1 second till the drop down loads
			  Thread.sleep(1000);
			  
			  //select the Enabled option
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]")).click();
			  
			  //Wait for 1 second till enabled option is selected
			  Thread.sleep(1000);
		  }	
	  
	  public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		  //Convert web driver object to TakeScreenshot
		  TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		  
		  //Call getScreenshotAs method to create image file
		  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		  
		  //Move image file to new destination
		  File DestFile=new File(fileWithPath);
		  
		  //Copy file at destination
		  FileUtils.copyFile(SrcFile, DestFile);
		  
	  }
	
	
}

