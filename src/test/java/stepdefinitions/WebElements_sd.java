package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import ch.qos.logback.classic.Logger;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.WebElements_page;
import utils.LoggerLoad;


public class WebElements_sd {
	
	WebElements_page checkboxpage =new  WebElements_page();
	
	
		@Given("The Users is on the webdriveruniversity.com in Page")
		public void the_Users_is_on_the_webdriveruniversity_com_in_page() {
			LoggerLoad.info("The users is on the Webdriver University Page");
		}
	

		@When("User click on link Dropdown,Checkbox,RadioButton testing")
		public void user_click_on_link_dropdown_checkbox_radio_button_testing() {
			checkboxpage.islink1clicked();
			
		}
		
		@Then("User should see page for testing Dropdown,Checkbox,RadioButton")
		public void user_should_see_page_for_testing_dropdown_checkbox_radio_button() {
			Assert.assertTrue(checkboxpage.isdisplayed(), "Testing all item page is showed");
		}
		
		//-----------------------------------checkbox code---------------------------------------------------------------------------------
		
		@Given("User navigates to the checkbox page")
	    public void user_navigates_to_checkbox_page() {
			
			checkboxpage.islink1clicked();
			LoggerLoad.info("The users is on the Webdriver University checkbox Page");
	        
	    }

	    @When("User selects the checkboxes")
	    public void user_selects_the_checkboxes(DataTable dataTable) { //The DataTable (like a mini table in the feature file) is converted into a List<String>.
	        List<String> options = dataTable.asList();
	        for (String option : options) {
	            checkboxpage.selectCheckbox(option);
	        }
	    }

	    @Then("Checkboxes should be selected")
	    public void checkboxes_should_be_selected(DataTable dataTable) {
	        List<String> options = dataTable.asList();
	        for (String option : options) {
	            Assert.assertTrue(checkboxpage.isCheckboxSelected(option), "Checkbox " + option + " is not selected.");
	        }
	    }
		
	  // --------------------------------------radio button code --------------------------------------------------------------------------- 
	    
	    @Given("The user is on the WebdriverUniversity radio button test page")
	    public void the_user_is_on_the_webdriver_university_radio_button_test_page() {
	    	checkboxpage.islink1clicked();
			LoggerLoad.info("The users is on the Webdriver University radio button Page");
	        
	    }

	    @When("User selects radio button {string}")
	    public void user_selects_radio_button(String color) {
	        checkboxpage.selectRadioButton(color);
	    }

	    @Then("Radio button {string} should be selected")
	    public void radio_button_should_be_selected(String color) {
	       
	       Assert.assertTrue(checkboxpage.isRadioButtonSelected(color), "Radio button '" + color + "' is not selected.");
	    }
		

	    //-------------------------------------dropdown code---------------------------------------------------
	 
	    
	    @Given("User is on the dropdown menu page")
	    public void user_is_on_the_dropdown_menu_page() {
	    	checkboxpage.islink1clicked();
			LoggerLoad.info("The users is on the Webdriver University dropdown Page");
	    }

	    @When("User selects {string} from the first dropdown")
	    public void user_selects_from_the_first_dropdown(String language) {
	    	 checkboxpage.selectLanguage(language);
	    }

	    @Then("{string} should be selected in the dropdown")
	    public void should_be_selected_in_the_dropdown(String expected) {
	    	 String actual = checkboxpage.getSelectedLanguage();
	         Assert.assertEquals(actual, expected);
	    }
	    
	    //--------------------file upload code  -------------------------------------------------
	    
	    
	    @Given("User is on the file upload page")
	    public void user_is_on_the_file_upload_page() {
	    	checkboxpage.islink2clicked();
			LoggerLoad.info("The users is on the Webdriver University pdf uplaod Page");
			//checkboxpage.switchToIframe();
			

	    }

	    @When("User uploads the file {string}")
	    public void user_uploads_the_file(String string) {
	    	checkboxpage.uploadFile(string);
	    }

	    @When("User clicks on the submit button")
	    public void user_clicks_on_the_submit_button() {
	    	checkboxpage.clickSubmit();
	    }
	        
	   	
	    @Then("An alert message {string} should be displayed")
	    public void alert_message_should_be_displayed (String expectedAlert) {
	    	
	    	String Submitalert=checkboxpage.Alertforsubmit();
	    	Assert.assertEquals(Submitalert, expectedAlert);
	    	}
	    	
	    
 //---------------------------------------not uplaod file code ---------------------------------

	@When("User clicks the submit button without selecting a file")
	public void user_clicks_the_submit_button_without_selecting_a_file() {
		
		checkboxpage.clickSubmit();
		
	}
	
	@Then("An non submission alert message {string} should be displayed")
	public void an_non_submission_alert_message_should_be_displayed(String nonSubmitExpectedAlert) {
		String nonSubmitalert=checkboxpage.Alertforsubmit();
    	Assert.assertEquals(nonSubmitalert, nonSubmitExpectedAlert);
	}
	    
	    
}	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
