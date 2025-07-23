package pagefactory;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverManager;
import utils.ExcelReader;


public class WebElements_page {
	
	
	WebDriver driver= DriverManager.getdriver();
	ConfigReader configFileReader=DriverManager.configReader();
	ExcelReader reader = new ExcelReader();        // add for data driven 
	//String Excelpath = ConfigReader.excelpath(); // add for data driven 
	
//----------------below @FindBy method for locators(xpath)---------------------------------------------------------------------
	

	@FindBy(xpath ="//div[@class='section-title']//h1[text()='DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)']")WebElement Link1; 	// link for chkbox.radiobutton,dropdown
  
  	//@FindBy(xpath ="//div[@id='main-header']//h1']")WebElement page1;
	
	@FindBy(xpath ="//div[@class='section-title']//h1[text()='FILE UPLOAD']")WebElement Link2; 			                //link for pdf upload
	
	@FindBy(xpath="//div[contains(@class,'section-title')]//h1[text()='IFRAME']")WebElement FrameLink; 				// locator for frame 
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']//a[@href='products.html']")WebElement OurProducts; 				//locator for OurProduct
	
	@FindBy(xpath="//a[contains(text(), 'New Approach')]")WebElement NewApproachToLearning ;					//locator for NewApproch
	
	@FindBy(xpath="//h1[text()='DATEPICKER']")WebElement DateLink;  								// locator for date
	
	@FindBy(xpath="//div[@id='datepicker']")WebElement DatePicker;									//locator for Datepicker ,we can not edit /clear it ,we need input inside it.
	
	@FindBy(css = "#datepicker input") WebElement DateInput;									//locator for Dateinput
	
	//@FindBy(xpath ="//div[@id='datepicker']/input") WebElement dateInput;								//locator for Dateinput using xpath
	
	
	
	
//-------------------below by locator methods----------------------------------------------------------------------------------
	
    private By javaDropdown = By.id("dropdowm-menu-1");                           							// Locator for first dropdown
    
   
   //private By iframe = By.cssSelector("iframe");                                							//Locators for frame and file upload
   //private By iframe = By.cssSelector("iframe[src='file-upload/index.html']");  							//Locators for frame and file upload
   //private By fileInput = By.xpath("//input[@id='myFile']");
   
     private By fileInput = By.id("myFile"); 												// locator for file uplaod 
   //private By fileInput = By.xpath("//input[@type='file']"); 										// locator for file uplaod 
    
     private By submitBtn = By.xpath("//input[@id='submit-button']");									//locator for submit button
    

//-------------------------------------below code for constructor for initializing driver----------------------------------------
	
	public WebElements_page ()   {  
		
		PageFactory.initElements(driver , this);

	}
	
//----------------------------------below all methods code start here------------------------------------------------------------
	
	
	public void islink1clicked()
	{
		Link1.click(); 							// going for checkbox,dropdown,radio button page
				
										//-----below code for switching to new window
		
		//String parentWindow = driver.getWindowHandle();     		// storing id of parent window in case you want to come back.
		
		for (String winHandle : driver.getWindowHandles()) {   		// loop for handling all child windows handle.
		    
			driver.switchTo().window(winHandle);               		// switch to child window.
		    
		    //driver.switchTo().window(parentWindow); 				// code for coming back to parent window.
																
		}
	}
	
		public boolean isdisplayed() 
		{
		
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//h1[contains(text(), 'Dropdown')]")));
		    return heading.isDisplayed();
		}
	
	
// -------below code from checkbox selection-----have dynamic xpath----------------------------------------------------------------
	
	public void selectCheckbox(String optionLabel) {
        WebElement checkbox = driver.findElement(By.xpath("//label[contains(.,'" + optionLabel + "')]/input[@type='checkbox']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isCheckboxSelected(String optionLabel) {
        WebElement checkbox = driver.findElement(By.xpath("//label[contains(.,'" + optionLabel + "')]/input[@type='checkbox']"));
        return checkbox.isSelected();
    }
    
//----------------------------------below code for radio button selection--------------------------------------------------------
   

    public void selectRadioButton(String color) {
        List<WebElement> radios = DriverManager.getdriver().findElements(By.name("color"));
        for (WebElement radio : radios) {
            if (radio.getAttribute("value").equalsIgnoreCase(color)) {
                radio.click();
                break;
            }
        }
    }

    public boolean isRadioButtonSelected(String color) {
        List<WebElement> radios = DriverManager.getdriver().findElements(By.name("color"));
        for (WebElement radio : radios) {
            if (radio.getAttribute("value").equalsIgnoreCase(color)) {
                return radio.isSelected();
            }
        }
        return false;
    }

//-----------------------------------below code for dropdown---------------------------------------------------------------------
    
    
    // Method to select option
    public void selectLanguage(String language) {
        Select dropdown = new Select(driver.findElement(javaDropdown));
        dropdown.selectByVisibleText(language);
    }

    // Method to get selected option
    public String getSelectedLanguage() {
        Select dropdown = new Select(driver.findElement(javaDropdown));
        return dropdown.getFirstSelectedOption().getText();
    }

 //-------- below code for file upload--------------------------------------------------------------------------------------------
   
  
//    public void uploadFile(String fileName) {
//    String filePath = System.getProperty("user.dir") + File.separator + "test-data" + File.separator + fileName;
//    driver.findElement(fileInput).sendKeys(filePath);
//    }
    
    
    public void uploadFile(String fileName) {
    	
    
//String filePath = System.getProperty("user.dir") + File.separator + "test-data" + File.separator + fileName;
//String filepath ="./src/test/resources/test-data/sample.png";
    	
    	String relativePath = "./src/test/resources/test-data/sample.png";
    	String absolutePath = new File(relativePath).getAbsolutePath();
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(fileInput));

        uploadElement.sendKeys(absolutePath);
    }
    
    

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }


	public void islink2clicked() {
		
		Link2.click();   // for clicking upload file page
		
		//-----below code for switching to new window
		
		//String parentWindow = driver.getWindowHandle();    		// storing id of parent window in case you want to come back.
		
    	for (String winHandle : driver.getWindowHandles()) {   			// loop for handling all child windows handle.
    			    
    		
    	driver.switchTo().window(winHandle);               	  		// switch to child window.
    			    		
    	//driver.switchTo().window(parentWindow); 			 	// code for coming back to parent window.
    
    	}	
				
	}
		
	public String Alertforsubmit() {
        
        // Switch to alert and capture text
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept(); // Close the alert
        return alertText;
	}
	
	//-----------------------------------code for frame ------------------------------------------------------------------------
	
    public void islink3clicked() {
		
    FrameLink.click();   // for clicking frame page
		
	//-----below code for switching to new window
		
	//String parentWindow = driver.getWindowHandle();     			// storing id of parent window in case you want to come back.
		
    	for (String winHandle : driver.getWindowHandles()) {   			// loop for handling all child windows handle.
    			    
    		driver.switchTo().window(winHandle);               		//  switch to child window.
    			    
    //driver.switchTo().window(parentWindow); 				    	// code for coming back to parent window.
    
    	}	
				
	}

	public void switchToIframe() {            				// switching to frame
		driver.switchTo().frame(0);
		
	}

	public void OurProductclick() {
		OurProducts.click();
		
	}

	public boolean isOurProductGetSelected(String expectedTab) {
				
		WebElement section = driver.findElement(By.xpath("//a[contains(text(),'Our Products')]"));
        return section.isDisplayed();
		
		
	}
	
  //--------------------------------------------code for date picking -------------------------------------------------------------------------------------------------------	
	
	public void islink4clicked() {
		
	    DateLink.click();  							// for clicking datepicker page
			
		//-----below code for switching to new window
			
		//String parentWindow = driver.getWindowHandle();     		// storing id of parent window in case you want to come back.
			
	    	for (String winHandle : driver.getWindowHandles()) {   	         // loop for handling all child windows handle.
	    			    
	    		driver.switchTo().window(winHandle);               	//  switch to child window.
	    			    
	    //driver.switchTo().window(parentWindow); 				  // code for coming back to parent window.
	    
	    	}	
					
		}


	public void isselectDate(String date) {
		
//		DateInput.clear();
//		DateInput.sendKeys(date);

		JavascriptExecutor js = (JavascriptExecutor) driver;             			//If the input is read-only or hidden, you can bypass it with JS:
		js.executeScript("document.querySelector('#datepicker input').value='07-01-2025'");
		
													// Or with a WebElement
		WebElement dateInput = driver.findElement(By.id("datepicker"));
		js.executeScript("arguments[0].value='07-01-2025';", dateInput);

		
		    try {
		        Thread.sleep(500); 								// Add slight delay to allow value to register
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }

	}

	public String getSelectedDate() {
	    return DateInput.getAttribute("value");  
	}

		
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------


	
	
	
	
	

