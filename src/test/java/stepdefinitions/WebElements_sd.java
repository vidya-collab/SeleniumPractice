package stepdefinitions;

import java.util.List;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.WebElements_page;
import utils.LoggerLoad;	


public class WebElements_sd {
	
	WebElements_page webElements_page =new  WebElements_page();
	
	
		@Given("The Users is on the webdriveruniversity.com in Page")
		public void the_Users_is_on_the_webdriveruniversity_com_in_page() {
			LoggerLoad.info("The users is on the Webdriver University Page");
		}
	

		@When("User click on link Dropdown,Checkbox,RadioButton testing")
		public void user_click_on_link_dropdown_checkbox_radio_button_testing() {
			webElements_page.islink1clicked();
			
		}
		
		@Then("User should see page for testing Dropdown,Checkbox,RadioButton")
		public void user_should_see_page_for_testing_dropdown_checkbox_radio_button() {
			Assert.assertTrue(webElements_page.isdisplayed(), "Testing all item page is showed");
		}
		
		//-----------------------------------checkbox code-------------------------------------------------------------------------------------------------------------------------------
		
		@Given("User navigates to the checkbox page")
	    public void user_navigates_to_checkbox_page() {
			
			webElements_page.islink1clicked();
			LoggerLoad.info("The users is on the Webdriver University checkbox Page");
	        
	    }

	    @When("User selects the checkboxes")
	    public void user_selects_the_checkboxes(DataTable dataTable) { //The DataTable (like a mini table in the feature file) is converted into a List<String>.
	        List<String> options = dataTable.asList();
	        for (String option : options) {
	            webElements_page.selectCheckbox(option);
	        }
	    }

	    @Then("Checkboxes should be selected")
	    public void checkboxes_should_be_selected(DataTable dataTable) {
	        List<String> options = dataTable.asList();
	        for (String option : options) {
	            Assert.assertTrue(webElements_page.isCheckboxSelected(option), "Checkbox " + option + " is not selected.");
	        }
	    }
		
	  // --------------------------------------radio button code --------------------------------------------------------------------------------------------------------------------- 
	    
	    @Given("The user is on the WebdriverUniversity radio button test page")
	    public void the_user_is_on_the_webdriver_university_radio_button_test_page() {
	    	webElements_page.islink1clicked();
			LoggerLoad.info("The users is on the Webdriver University radio button Page");
	        
	    }

	    @When("User selects radio button {string}")
	    public void user_selects_radio_button(String color) {
	        webElements_page.selectRadioButton(color);
	    }

	    @Then("Radio button {string} should be selected")
	    public void radio_button_should_be_selected(String color) {
	       
	       Assert.assertTrue(webElements_page.isRadioButtonSelected(color), "Radio button '" + color + "' is not selected.");
	    }
		

	    //-------------------------------------dropdown code----------------------------------------------------------------------------------------------------------------------------------
	 
	    
	    @Given("User is on the dropdown menu page")
	    public void user_is_on_the_dropdown_menu_page() {
	    	webElements_page.islink1clicked();
			LoggerLoad.info("The users is on the Webdriver University dropdown Page");
	    }

	    @When("User selects {string} from the first dropdown")
	    public void user_selects_from_the_first_dropdown(String language) {
	    	 webElements_page.selectLanguage(language);
	    }

	    @Then("{string} should be selected in the dropdown")
	    public void should_be_selected_in_the_dropdown(String expected) {
	    	 String actual = webElements_page.getSelectedLanguage();
	         Assert.assertEquals(actual, expected);
	    }
	    
	    //--------------------file upload code  ----------------------------------------------------------------------------------------------------------------------------------------------
	    
	    
	    @Given("User is on the file upload page")
	    public void user_is_on_the_file_upload_page() {
	    	webElements_page.islink2clicked();
			LoggerLoad.info("The users is on the Webdriver University pdf uplaod Page");
			//WebElements_page.switchToIframe();
			

	    }

	    @When("User uploads the file {string}")
	    public void user_uploads_the_file(String string) {
	    	webElements_page.uploadFile(string);
	    }

	    @When("User clicks on the submit button")
	    public void user_clicks_on_the_submit_button() {
	    	webElements_page.clickSubmit();
	    }
	        
	   	
	    @Then("An alert message {string} should be displayed")
	    public void alert_message_should_be_displayed (String expectedAlert) {
	    	
	    	String Submitalert=webElements_page.Alertforsubmit();
	    	Assert.assertEquals(Submitalert, expectedAlert);
	    	}
	    	
	    
 //---------------------------------------file not uplaod file code -----------------------------------------------------------------------------------------------------------------------------------------------

	@When("User clicks the submit button without selecting a file")
	public void user_clicks_the_submit_button_without_selecting_a_file() {
		
		webElements_page.clickSubmit();
		
	}
	
	@Then("An non submission alert message {string} should be displayed")
	public void an_non_submission_alert_message_should_be_displayed(String nonSubmitExpectedAlert) {
		String nonSubmitalert=webElements_page.Alertforsubmit();
    	Assert.assertEquals(nonSubmitalert, nonSubmitExpectedAlert);
	}
	    
	
	
	//-----------------below code for handling frame-------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@Given("User navigates to the iframe page")
	public void user_navigates_to_the_iframe_page() {
		webElements_page.islink3clicked();
		LoggerLoad.info("The users is on the Webdriver University frame ");
		
	}

	@When("User switches to the iframe")
	public void user_switches_to_the_iframe() {
		webElements_page.switchToIframe();
	    
	}

	@When("User clicks on {string} tab")
	public void user_clicks_on_tab(String string) {
		webElements_page.OurProductclick();
	}

	
	@Then("{string} section should be displayed")
    public void section_should_be_displayed(String expectedTab) {
        Assert.assertTrue(webElements_page.isOurProductGetSelected(expectedTab));
    }
	    
	    
	    
	//---------------------------------------below code is for date picking-------------------------------------------------------

		@Given("User is on the Datepicker page")
		public void user_is_on_the_datepicker_page() {
			
			webElements_page.islink4clicked();
			LoggerLoad.info("The users is on the Datepicker page frame ");
		    
		}
		
		@When("User selects date {string}")
		public void user_selects_date(String date) {
		    
			webElements_page.isselectDate(date);
		    
		}
		
		@Then("Selected date should be {string}")
		public void selected_date_should_be(String expectedDate) {
		 
			String actualDate = webElements_page.getSelectedDate();
	        Assert.assertEquals(actualDate,expectedDate);
			
		}
			    
}   
			    
	    
	    
	    
	    
