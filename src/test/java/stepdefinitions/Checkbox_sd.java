package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.Checkboxpage;
import utils.LoggerLoad;


public class Checkbox_sd {
	
	Checkboxpage checkboxpage =new  Checkboxpage();
	
	
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
		
		//--------------------------------------------------------------------------------------------------------------------
		
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
		
	  // ----------------------------------------------------------------------------------------------------------------- 
	    
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
		

	    //----------------------------------------------------------------------------------------
	    
	}
