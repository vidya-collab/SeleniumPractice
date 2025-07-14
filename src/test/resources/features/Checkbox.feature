@Testingwebdriveruniversity.com 

Feature: Checkbox.Dropdown,RadioButton testing

  @LinkclickTest
  Scenario: User able to land on Dropdown,Checkbox,RadioButton testing webdriveruniversity.com Page
     Given The Users is on the webdriveruniversity.com in Page
     When User click on link Dropdown,Checkbox,RadioButton testing
     Then User should see page for testing Dropdown,Checkbox,RadioButton
     
   @Checkboxtest
  Scenario: Select multiple checkboxes from the checkbox section
    Given User navigates to the checkbox page
    When User selects the checkboxes
      | Option 1 |
      | Option 2 |
      | Option 3 |
      | Option 4  |
    Then Checkboxes should be selected
      | Option 1 |
      | Option 2 |
      | Option 3 |
      | Option 4 |
     
  
    @RadioButtonTest
    Scenario: User selects a radio button option
    Given The user is on the WebdriverUniversity radio button test page
    When User selects radio button "blue"
    Then Radio button "blue" should be selected
     