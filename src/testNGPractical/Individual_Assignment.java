package testNGPractical;

import java.io.File; 

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.google.common.io.Files;

public class Individual_Assignment {
	
	//Global variable declaration
	public String baseURL="https://www.saucedemo.com/";
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
	
	//Test cases
	//Test case 001 : Incorrect UN & PW
	@Test(priority=1)
	public void FailedUserLoginFunction1() throws Exception
	{
		System.out.println("---------------TC 001---------------");
		
		Thread.sleep(2000);
		//find the username 
		WebElement user_name = driver.findElement(By.id("user-name"));
		user_name.sendKeys("Janaka");
		Thread.sleep(1000);
		
		//find the password 
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12345");
		Thread.sleep(1000);
		
		//find the login button
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
		Thread.sleep(1000);
		
		// Check if the error message is present
		WebElement errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));

		if(errorMessage.isDisplayed()) {
			System.out.println("Test Case 001:Passed");
			System.out.println("Login Failed");
			
			// Take a screenshot of the error
			this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Login_Error1.png");
			
		}
		else {
			System.out.println("Test Case 001: Faield");
			System.out.println("Login Passed");
		}
		
	}
	
	//Test case 002 : Correct UN, Incorrect PW
	@Test(priority=2)
	public void FailedUserLoginFunction2() throws Exception {
		System.out.println("---------------TC 002---------------");
		
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		//find the username 
		WebElement user_name = driver.findElement(By.id("user-name"));
		user_name.sendKeys("standard_user");
		
		Thread.sleep(2000);
		//find the password 
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("1234");
		
		//find the login button
		Thread.sleep(1000);
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
		
		// Check if the error message is present
		WebElement errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
		
		if(errorMessage.isDisplayed()) {
			System.out.println("Test Case 002:Passed");
			System.out.println("Login Failed");
			
			// Take a screenshot of the error
			this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Login_Error2.png");
			
		}
		else {
			System.out.println("Test Case 002: Faield");
			System.out.println("Login Passed");
		}
		
	}
	
	//Test Case 003: Icorrect un & Correct PW
	@Test(priority=3)
	public void FailedUserLoginFunction3() throws Exception {
		System.out.println("---------------TC 003---------------");
		
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		//find the username 
		WebElement user_name = driver.findElement(By.id("user-name"));
		user_name.sendKeys("nadun");
		
		Thread.sleep(2000);
		//find the password 
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
		//find the login button
		Thread.sleep(1000);
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
		Thread.sleep(2000);
		
		// Check if the error message is present
		WebElement errorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
		
		if(errorMessage.isDisplayed()) {
			System.out.println("Test Case 003:Passed");
			System.out.println("Login Failed");
			
			// Take a screenshot of the error
			this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Login_Error3.png");
			
		}
		else {
			System.out.println("Test Case 003: Faield");
			System.out.println("Login Passed");
		}
		
	}
	

		//Test Case 004: Correct UN & PW
		@Test(priority=4)
		public void SuccessUserLoginFunction() throws Exception {
			System.out.println("---------------TC 004---------------");
			
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			
			//find the username 
			WebElement user_name = driver.findElement(By.id("user-name"));
			user_name.sendKeys("standard_user");
			
			Thread.sleep(2000);
			//find the password 
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("secret_sauce");
			
			//find the login button
			Thread.sleep(1000);
			WebElement loginbtn = driver.findElement(By.id("login-button"));
			loginbtn.click();
			Thread.sleep(2000);
			
			// Check if the error message is present
			String expected_url = "https://www.saucedemo.com/inventory.html";
			String actual_url = driver.getCurrentUrl();
			
			if(expected_url.equals (actual_url)) {
				
				System.out.println("Test Case 004:Passed");
				System.out.println("Login Passed");
				// Take a screenshot of the expected page
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Login_Success.png");
				
			}
			else {
				
				System.out.println("Test Case 004: Faield");
				System.out.println("Login Failed");
				
			}
			
		}
		
		//Test Case 005: Verify the loaded page
		@Test(priority=5)
		public void VerifyLoadedResult() throws Exception {
			System.out.println("---------------TC 005---------------");
			//UserLogin();
			Thread.sleep(2000);
			
			//Find all product list
			List<WebElement> product_items = driver.findElements(By.className("inventory_item"));
			
			//expected product count that display on page
			int expected_product_count = 6;
			
			//check the actual result match with expected result
			if(product_items.size()== expected_product_count) {
				
				System.out.println("Test Case 005:Passed");
				System.out.println("Display all Products");
				
				// Take a screenshot of the product that displayed
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Display_Products.png");
				
			}
			else {
				
				System.out.println("Test Case 005: Faield");
				System.out.println("All products are not displayed");
				
			}
		}
		
		//Test Case 006: Verify products text is displayed
		@Test(priority=6)
		public void VerifyHeaderText() throws Exception {
			System.out.println("---------------TC 006---------------");
			Thread.sleep(2000);
			
			//find the text "Product"
			WebElement elementhead = driver.findElement(By.className("title"));
			elementhead.getText();		
					
			//check the product text displayed or not
			  if (elementhead.isDisplayed()) {
				System.out.println("Test Case 006:Passed");
				System.out.println("Display expected text on page header" );
						
				// Take a screenshot of the text
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Display_Products(text).png");
						
			}
			else {
						
				System.out.println("Test Case 006: Faield");
				System.out.println("Expected text is not displayed");
						
			}
	}
		//Test Case 007: Verify title is displayed
		@Test(priority=7)
		public void VerifyPageTitle() throws Exception {
			System.out.println("---------------TC 007---------------");
			Thread.sleep(2000);
					
			//Find the page title
			String expected_title = "Swag Labs";
			
			String actual_title = driver.getTitle();	
					
			//check whether the actual title is match to the expected title
			  if (expected_title.equals(actual_title)) {
				System.out.println("Test Case 007:Passed");
				System.out.println("Display the expected tile" );
						
				// Take a screenshot of the title
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Display_Title.png");
						
			}
			else {		
				System.out.println("Test Case 007: Faield");
				System.out.println("Expected title is not displayed");						
			}
	}
		
		//Test Case 008: Add to cart button transition
		@Test(priority = 8)
		public void ButtonTrasition() throws Exception {
		    System.out.println("---------------TC 008---------------");
		    //Thread.sleep(2000);

		    WebElement addcart_btn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		    addcart_btn.click();
		    Thread.sleep(5000);
		    
		    //Button change find handling
		    try {
		    	WebElement remove_btn = driver.findElement(By.id("remove-sauce-labs-backpack"));
		    	
		    	if (remove_btn.isDisplayed()) {
			        System.out.println("Test Case 008: Passed");
			        System.out.println("Add to Cart button is changed to Remove Button");

			        // Take a screenshot of the title
			        this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Button_Change.png");

			    } else {
			        System.out.println("Test Case 008: Failed");
			        System.out.println("Button is not changed");
			    }
		    	
		    }catch (TimeoutException e){
		    	 System.out.println("Test Case 008: Failed");
		         System.out.println("Remove button not found");	    	
		    }
	    
		}
		
		//Test Case 009: Verify the cart icon count is not 0
		@Test(priority=9)
		public void CartItemCount() throws Exception {
		    System.out.println("---------------TC 009---------------");
		    
		    //Identify the cart count
		    WebElement cartcount = driver.findElement(By.className("shopping_cart_badge"));
		    
		    //check the cart whether empty or not
		    if(cartcount.getText().equals("1")) {
		    	
		    	System.out.println("Test Case 009: Passed");
		        System.out.println("Cart is not empty");

		        // Take a screenshot of the title
		        this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Cartcount.png");
		    	
		    }else {
		    	System.out.println("Test Case 009: Failed");
		        System.out.println("Cart is empty");
		    }
	    
		}
		
		//Test Case10: Click on cart icon
		@Test(priority=10)
		public void ClickcartIcon() throws Exception {
		    System.out.println("---------------TC 010---------------");
		    Thread.sleep(2000);
		    
		    //Identify the cart icon and click
		    WebElement carticon = driver.findElement(By.xpath("html/body/div/div/div/div[1]/div[1]/div[3]/a"));
		    carticon.click();
		    
		    //Set target url
		    String expected_url = "https://www.saucedemo.com/cart.html";
		    String actual_url = driver.getCurrentUrl();
		    
		    //compare the expected and actual urls
		    if(expected_url.equals(actual_url)) {
		    	
		    	System.out.println("Test Case 010: Passed");
		        System.out.println("Successfully load the target page");

		        // Take a screenshot of the target page
		        this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\After_Click_Cart_Icon.png");
		    	
		    }else {
		    	System.out.println("Test Case 010: Failed");
		        System.out.println("Target page is not load");
		    }
		}
		
		//Test Case 011: Verify the display "Your Cart" cart page header 
		@Test(priority=11)
		public void VerifyCartHeaderText() throws Exception {
			System.out.println("---------------TC 011---------------");
			Thread.sleep(2000);
			
			//find header text called "Your Cart"
			WebElement elementheadtxt = driver.findElement(By.className("title"));
			elementheadtxt.getText();	
					
			//check the text displayed or not
			  if (elementheadtxt.isDisplayed()) {
				System.out.println("Test Case 011:Passed");
				System.out.println("Displayed the expected text on page header: " + elementheadtxt.getText() );		
				// Take a screenshot of the text
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Display_YourCart.png");					
			}
			else {		
				System.out.println("Test Case 011: Faield");
				System.out.println("Expected text is not displayed");			
			}
	}
		
		//Test Case 012: Verify all the details of item is display on the page
		@Test(priority=12)
		public void VerifyItemDetails() throws Exception {
			System.out.println("---------------TC 012---------------");
			Thread.sleep(2000);
			
			//Identify the product name and description
			WebElement product_name = driver.findElement(By.className("inventory_item_name"));
			WebElement product_dsc = driver.findElement(By.className("inventory_item_desc"));
					
			//check the item details are displayed or not
			  if ((product_name != null) && (product_dsc != null)) {
				System.out.println("Test Case 012:Passed");
				System.out.println("Item details are display on the page" );		
				// Take a screenshot of the item details
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Item_Details.png");					
			}
			else {		
				System.out.println("Test Case 011: Faield");
				System.out.println("Item details are not display on the page");			
			}
	}
		
		//Test Case: Verify the item price
		@Test(priority=13)
		public void VerifyItemPrice() throws Exception {
			System.out.println("---------------TC 013---------------");
			Thread.sleep(2000);
			
			//Identify the product price
			WebElement product_price = driver.findElement(By.className("inventory_item_price"));
			
			//check the price is displayed or not
			  if ((product_price != null)) {
				String dollar_icon =  product_price.getText();
				  if(dollar_icon.contains("$")) {
					  	System.out.println("Test Case 013:Passed");
				  		System.out.println("Item price and dollar icon is display on the page" );		
				  		// Take a screenshot of the price
				  		this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Item_Price.png");	
				  }
				  else {
					  System.out.println("Test Case 013: Faield");
					  System.out.println("Item price and dollar icon is not display on the page"); 
				  }
			}
			else {		
				System.out.println("Test Case 013: Faield");
				System.out.println("Item price is not display on the page");			
			}
	}
		
		//Test Case 014: Verify the item count display on cart page
		@Test(priority=14)
		public void VerifyItemCount() throws Exception {
		    System.out.println("---------------TC 014---------------");
		    Thread.sleep(2000);
		    
		    //Identify the item count
		    WebElement itemcount = driver.findElement(By.className("cart_quantity"));
		    
		    //check the cart whether empty or not
		    if(itemcount != null) {
		    	System.out.println("Test Case 014: Passed");
		        System.out.println("Display count on cart page: " + itemcount.getText());

		        // Take a screenshot of item count
		        this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Item_Count.png");
		    	
		    }else {
		    	System.out.println("Test Case 014: Failed");
		        System.out.println("No items display on the page");
		    }
	    
		}
		
		//Test Case 015: Verify the continue shopping button
		@Test(priority=15)
		public void ContinueShoppingBTN() throws Exception {
		    System.out.println("---------------TC 015---------------");
		    Thread.sleep(2000);
		    
		    //Identify the item count
		    WebElement conshp_btn = driver.findElement(By.id("continue-shopping"));
		    conshp_btn.click();
		    
		    //set the expected and actual urls
		    String expected_url = "https://www.saucedemo.com/inventory.html";
		    String actual_url = driver.getCurrentUrl();
		    
		    //check the expected and actual urls
		    if(expected_url.equals(actual_url)) {
		    	System.out.println("Test Case 015: Passed");
		        System.out.println("Move back to previous inventory page");
		        // Take a screenshot of the move back page
		        this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Inventory_Page.png");
		        
		        //click cart icon for the go to cart page
		        Thread.sleep(3000);
		        WebElement carticon = driver.findElement(By.xpath("html/body/div/div/div/div[1]/div[1]/div[3]/a"));
			    carticon.click();
		    	
		    }else {
		    	System.out.println("Test Case 015: Failed");
		        System.out.println("Not go to the expected page");
		    }
	    
		}
		
		//Test Case 016: Verify the remove button is clicked and item details are removes 
		@Test(priority=16)
		public void RemoveBTN() throws Exception {
	        System.out.println("---------------TC 016---------------");
	        Thread.sleep(3000);

	        // Find the remove button and click it
	        WebElement removeBtn = driver.findElement(By.id("remove-sauce-labs-backpack"));
	        removeBtn.click();
	        Thread.sleep(2000);
	        
	        WebElement removeitemelemnt = driver.findElement(By.className("removed_cart_item"));
	        removeitemelemnt.getText();
	        
	        if (removeitemelemnt.getText() != null) { 	
	        	//item is not displayed
	            System.out.println("Test Case 016: Passed");
	            System.out.println("Item is removed after the click the remove button");

	            // Take a screenshot of the empty page
	            this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Empty_Cart_Page.png");
	            Thread.sleep(2000);

	            // go back to items page again
	            driver.navigate().back();
	            Thread.sleep(3000);

	            // add again item and come to the cart
	            addCart();
	        } else {
	        	//item is displayed
	            System.out.println("Test Case 016: Failed");
	            System.out.println("Item is not removed after the click the remove button");
	        	
	        }
		}
		
		//Test Case 017: Verify the checkout button
		@Test(priority=17)
		public void CheckoutBTN() throws Exception {
		    System.out.println("---------------TC 016---------------");
		    Thread.sleep(2000);
		    
		    //Identify the checkout button
		    WebElement chkout_btn = driver.findElement(By.id("checkout"));
		    chkout_btn.click();
		    
		    //set the expected and actual urls
		    String expected_url = "https://www.saucedemo.com/checkout-step-one.html";
		    String actual_url = driver.getCurrentUrl();
		    
		    if(expected_url.equals(actual_url)) {
		    	//load the checkout page
		    	System.out.println("Test Case 017: Passed");
	            System.out.println("Successfully load the checkout page");
	            // Take a screenshot of checkout page
	            this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Checkout_Page.png");	            
		    }
		    else {
		    	//checkout page is not load
	            System.out.println("Test Case 017: Failed");
	            System.out.println("Checkout page is not load");
		    }
		}
		
		//Test Case 018:Verify the loaded checkout page
		@Test(priority=18)
		public void VerifyCheckoutHeaderText() throws Exception {
			System.out.println("---------------TC 018---------------");
			Thread.sleep(2000);
			
			//find header text called "Checkout: Your Information"
			WebElement elementheadtxt = driver.findElement(By.className("title"));
			elementheadtxt.getText();	
					
			//check the text displayed or not
			  if (elementheadtxt.isDisplayed()) {
				System.out.println("Test Case 018:Passed");
				System.out.println("Displayed the expected text on page header: " + elementheadtxt.getText() );		
				// Take a screenshot of the text "Checkout: Your Information"
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Displaytxt_Your_Information.png");					
			}
			else {		
				System.out.println("Test Case 018: Faield");
				System.out.println("Expected text is not displayed");			
			}
	}
		
		//Test Case: Verify the cancel button
		@Test(priority=19)
		public void CancelBTN() throws Exception {
		    System.out.println("---------------TC 019---------------");
		    Thread.sleep(2000);
		    
		    //Identify the checkout button
		    WebElement cancel_btn = driver.findElement(By.id("cancel"));
		    cancel_btn.click();
		    
		    //set the expected and actual urls
		    String expected_url = "https://www.saucedemo.com/cart.html";
		    String actual_url = driver.getCurrentUrl();
		    
		    if(expected_url.equals(actual_url)) {
		    	//load the cart page
		    	System.out.println("Test Case 019: Passed");
	            System.out.println("Successfully! work the cancel button");
	            // Take a screenshot of page that come after the click Cancel button
	            this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\After_Cancel_Page.png");
	            Thread.sleep(2000);
	            
	            WebElement chkout_btn = driver.findElement(By.id("checkout"));
			    chkout_btn.click();
	            
		    }
		    else {
		    	//cart page is not load
	            System.out.println("Test Case 019: Failed");
	            System.out.println("Cancel button is not work");
		    }
		}
		
		//Test Case 020: Verify the continue button without filling form
		@Test(priority=20)
		public void ContinueBTNerr1() throws Exception {
			System.out.println("---------------TC 020---------------");
			Thread.sleep(2000);
			
			WebElement continue_btn = driver.findElement(By.id("continue"));
			continue_btn.click();
			Thread.sleep(1000);
			
			WebElement errormsg = driver.findElement(By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error"));
			
			if(errormsg.isDisplayed()) {
				System.out.println("Test Case 020: Passed");
	            System.out.println("Error mesaage is popup after the click continue button without fill the form");
	            //Take the screenshot of the error message
	            this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Checkout_Error.png");
			}
			else {
				System.out.println("Test Case 020: Failed");
				System.out.println("Error mesaage is not popup after the click continue button without fill the form");
			}
		}
		
		//Test Case 021: Verify the continue button with half fill form
		@Test(priority=21)
		public void ContinueBTNerr2() throws Exception {
			System.out.println("---------------TC 021---------------");
			Thread.sleep(2000);
			
			//refresh the page
			driver.navigate().refresh();
			
			//find the first name element
			WebElement first_name = driver.findElement(By.id("first-name"));
			first_name.sendKeys("Nadun");
			
			//find the continue button
			WebElement continue_btn = driver.findElement(By.id("continue"));
			continue_btn.click();
			Thread.sleep(1000);
			
			//find the error message
			WebElement errormsg = driver.findElement(By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error"));
			
			//find the error icon
			WebElement error_icon = driver.findElement(By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div:nth-child(1) > svg"));
						
			if(errormsg.isDisplayed()) {
				if(error_icon.isDisplayed()) {
					System.out.println("Test Case 021: Failed");
		            System.out.println("Error Icon is sitll showing on first name fiels");
		            //Take the screenshot of the error icon
		            Individual_Assignment.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Saved Pictures\\Error_Icon_onfirstname.png");
				}
				else {
					System.out.println("Test Case 021: Passes");
					System.out.println("Error Icon is sitll showing on first name fiels");
				}
			}
			else{
				System.out.println("Test Case 021: Failed");
				System.out.println("Error mesaage is not popup after the click continue button without fill the form");
			}
		}
		
		//Test Case 022: Verify the continue button with fill all fields in the form
		@Test(priority=22)
		public void ContinueBTN() throws Exception {
			System.out.println("---------------TC 021---------------");
			Thread.sleep(2000);
			
			//refresh the page
			driver.navigate().refresh();
			Thread.sleep(1000);
			
			//find the first name, last name and postal code elements
			WebElement first_name = driver.findElement(By.id("first-name"));
			first_name.sendKeys("Nadun");
			Thread.sleep(1000);
			
			WebElement last_name = driver.findElement(By.id("last-name"));
			last_name.sendKeys("Bandara");
			Thread.sleep(1000);
			
			WebElement post_code = driver.findElement(By.id("postal-code"));
			post_code.sendKeys("71000");
			Thread.sleep(1000);
			
			//find the continue button
			WebElement continue_btn = driver.findElement(By.id("continue"));
			continue_btn.click();
			Thread.sleep(2000);
			
			//get url after the click continue button
			String expected_url = "https://www.saucedemo.com/checkout-step-two.html";
			String actual_url = driver.getCurrentUrl();
			
			//check the urls
			if(expected_url.equals(actual_url)) {
				
				System.out.println("Test Case 022: Passed");
	            System.out.println("Expected url is load after clik continue button");
	            //Take the screenshot of the page the come after click continue button
	            this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Expected_Page.png");
	            
			}
			else {
				
				System.out.println("Test Case 022: Failed");
				System.out.println("Expected url is not load after clik continue button");
				
			}
		}
		
		//Test Case 022: Verify the header txt in checkout overview
		@Test(priority=22)
		public void VerifyCheckoutHeaderTxt() throws Exception {
			System.out.println("---------------TC 022---------------");
			Thread.sleep(2000);
			
			//find header text called "Checkout: Overview"
			WebElement elementheadtxt = driver.findElement(By.className("title"));
			elementheadtxt.getText();	
					
			//check the text displayed or not
			  if (elementheadtxt.isDisplayed()) {
				System.out.println("Test Case 022:Passed");
				System.out.println("Displayed the expected text on page header: " + elementheadtxt.getText() );		
				// Take a screenshot of the text "Checkout: Overview"
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Displaytxt_Overview.png");					
			}
			else {		
				System.out.println("Test Case 022: Faield");
				System.out.println("Expected text is not displayed");			
			}
	}
		
		//Test Case 023: Compare the Item prices showing on overview page
		@Test(priority=23)
		public void ComparePrice() throws Exception {
			System.out.println("---------------TC 023---------------");
			Thread.sleep(2000);
			
			//find the prices
			WebElement item_price = driver.findElement(By.cssSelector("#checkout_summary_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.item_pricebar > div"));	
			WebElement subtotal_price = driver.findElement(By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_subtotal_label"));
			
			//get text values of the prices
			String itemprice_txt = item_price.getText().trim().replaceAll("[^0-9.]+", "");
			String subtotalprice_txt = subtotal_price.getText().trim().replaceAll("[^0-9.]+", "");
			
			//Extract the price values
			Double itemprice_value = Double.parseDouble(itemprice_txt);
			Double subtotalprice_value = Double.parseDouble(subtotalprice_txt);
			
			//Compare the prices
			if ((itemprice_value).equals(subtotalprice_value)) {
				
				System.out.println("Test Case 023:Passed");
				System.out.println("Display Prices are equal");
				// Take a screenshot of the prices
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Display_Prices.png");
			
			}
			else {
				
				System.out.println("Test Case 023: Faield");
				System.out.println("Display prices are not equal. "+ item_price.getText() + "and" + subtotal_price.getText() + "prices are showing");
			
			}
			  
	}
		
		//Test Case 024: Verify the total price calculation
		@Test(priority=24)
		public void PriceCalculation() throws Exception {
			System.out.println("---------------TC 024---------------");
			Thread.sleep(2000);
			
			//find the prices: item total, tax, total	
			WebElement subtotal_price = driver.findElement(By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_subtotal_label"));
			WebElement tax_price = driver.findElement(By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_tax_label"));
			WebElement total_price = driver.findElement(By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_info_label.summary_total_label"));
			
			//get text values of the prices
			String subtotalprice_txt = subtotal_price.getText().trim().replaceAll("[^0-9.]+", "");
			String taxprice_txt = tax_price.getText().trim().replaceAll("[^0-9.]+", "");
			String totalprice_txt = total_price.getText().trim().replaceAll("[^0-9.]+", "");

			
			//Extract the price values
			Double subtotalprice_value = Double.parseDouble(subtotalprice_txt);
			Double taxprice_value = Double.parseDouble(taxprice_txt);
			Double totalprice_value = Double.parseDouble(totalprice_txt);
			
			//Compare the prices
			if ((subtotalprice_value)+(taxprice_value) == (totalprice_value)) {
				
				System.out.println("Test Case 024:Passed");
				System.out.println("Price calcuation is correct. Total price is "+ total_price.getText());
				// Take a screenshot of the prices
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Display_Total_Price_Calculation.png");
			
			}
			else {
				
				System.out.println("Test Case 024: Faield");
				System.out.println("Price calcuation is not correct");
			
			}			 
	}
		
		//Test Case 25: Verify the finished button
		@Test(priority=25)
		public void finishbutton() throws Exception {
			System.out.println("---------------TC 025---------------");
			Thread.sleep(2000);
			
			//find the finish button	
			WebElement finish_btn = driver.findElement(By.id("finish"));
			finish_btn.click();
			Thread.sleep(2000);
			
			//get url after the click finish button 
			String expected_url = "https://www.saucedemo.com/checkout-complete.html";
			String actual_url = driver.getCurrentUrl();
			
			if(expected_url.equals(actual_url)) {
				
				System.out.println("Test Case 025.1:Passed");
				System.out.println("Expected page is load after the click finish button");
				// Take a screenshot of the final loaded page
				this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Final_Expected_Page.png");
				Thread.sleep(2000);
				
				//find header text called "Checkout: Complete!"
				WebElement elementheadtxt = driver.findElement(By.className("title"));
				elementheadtxt.getText();	
						
				  //check the text displayed or not
				  if (elementheadtxt.isDisplayed()) {
					System.out.println("Test Case 025.2:Passed");
					System.out.println("Displayed the expected text on page header: " + elementheadtxt.getText() );		
					// Take a screenshot of the text "Checkout: Overview"
					this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Displaytxt_Complete.png");	
					Thread.sleep(2000);
					
					//find the complete message 
					WebElement complete_msg = driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
					complete_msg.getText();
					
					//check the complete message displayed or not
						if (complete_msg.isDisplayed()) {
						
							System.out.println("Test Case 025.3:Passed");
							System.out.println("Displayed the complete message on page: " + complete_msg.getText() );
							this.takeSnapShot(driver, "C:\\Users\\Janaka Sajith\\OneDrive\\Pictures\\Snapshots\\Display_Complete_Message.png");
							Thread.sleep(1000);
							
							//Go back to home
							WebElement gohome_btn = driver.findElement(By.cssSelector("#back-to-products"));
							gohome_btn.click();
							
							System.out.println("---------------Finished Test Swag Labs Application---------------");
							System.out.println("===============================================");
							System.out.println("---------------Complete The Assignment---------------");
							System.out.println("===============================================");
							System.out.println("---------------Student Name: Janaka Sajith Priyankara+---------------");
						
						}
						else {
							
							System.out.println("Test Case 025.3: Faield");
							System.out.println("Expected complete message is not displayed");
							
						}
				  }
				  else {		
					  System.out.println("Test Case 025.2: Faield");
					  System.out.println("Expected text is not displayed");			
				  }
			}
			else {
				
				System.out.println("Test Case 025.1:Failed");
				System.out.println("Expected page is not load after the click finish button");
				
			}			 
	}
		
		
	
	//After test
	@AfterTest
	public void AfterTestExecutionProcess() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();//close the browser
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot)webdriver);
		  
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		  
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		  
		//Copy file at destination
		//FileUtil.copy(SrcFile, DestFile);
		Files.copy(SrcFile, DestFile);
	}
	
	//user this for help to continue to prevent the all code parts run while coding
	public void UserLogin() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(3000);
		
		//find the username & password
		WebElement user_name = driver.findElement(By.id("user-name"));
		user_name.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
		//find the login button
		Thread.sleep(2000);
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
		Thread.sleep(3000);
	}
	
	public void addCart() throws Exception{
		
		//find the add to cart button and click it
		WebElement addcart_btn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
	    addcart_btn.click();
	    Thread.sleep(2000);
	    
	    //find the cart icon and click it
	    WebElement carticon = driver.findElement(By.xpath("html/body/div/div/div/div[1]/div[1]/div[3]/a"));
	    carticon.click();
	    Thread.sleep(2000);
	    
	}
 
  
}

