package pagefactory;


import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.netty.handler.timeout.TimeoutException;
import utils.ExcelReader;
import utils.ConfigReader;
import utils.DriverManager;
import java.time.Duration;


public class Checkboxpage {
	
	
	WebDriver driver= DriverManager.getdriver();
	ConfigReader configFileReader=DriverManager.configReader();
	ExcelReader reader = new ExcelReader();      // add for data driven 
	//String Excelpath = ConfigReader.excelpath(); // add for data driven 
	


	//-----------------@FIndBy method for locartors(xpath)-------------------------
	

	@FindBy(xpath ="//div[@class='section-title']//h1[text()='DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)']")WebElement Link1;
  
   //@FindBy(xpath ="//div[@id='main-header']//h1']")WebElement page1;
	
	
	
	//-------------------------------------constructor for initializing driver---------
	
	public Checkboxpage ()   {  
		
		PageFactory.initElements(driver , this);

	}
	
	
	//----------------------------------all methods------------------------------
	
	
	public void islink1clicked()
	{
		Link1.click();
		
		
	//--------------- code for switching to new window.----------------------------
		
		//String parentWindow = driver.getWindowHandle();     // storing id of parent window in case you want to come back.
		for (String winHandle : driver.getWindowHandles()) {   // loop for handling all child windows handle.
		    driver.switchTo().window(winHandle);               //  switch to child window.
		    
		    //driver.switchTo().window(parentWindow); // code for coming back to parent window.
		}

	}
	
	
	public boolean isdisplayed() {
		
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//h1[contains(text(), 'Dropdown')]")));
		    return heading.isDisplayed();
		}
	
	
	// -------code from cherckbox selection-----have dynamic xpath----------------------------------------------------------------
	
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
    
    //----------------------------------code for radio buttion selection------------------------------------------------------------------
   

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

}
		

	
	
	
	
	

