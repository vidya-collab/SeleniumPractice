@Testingwebdriveruniversity.com
Feature: Testing web Elements from above website Checkbox,Dropdown,RadioButton testing,file upload

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
      | Option 4 |
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

  @DropdownTest
  Scenario: Select Java option from the dropdown menu
    Given User is on the dropdown menu page
    When User selects "JAVA" from the first dropdown
    Then "JAVA" should be selected in the dropdown

  @FileUploadfunctionality
  Scenario: Upload a file using the file upload form
    Given User is on the file upload page
    When User uploads the file "sample.png"
    And User clicks on the submit button
    Then An alert message "Your file has now been uploaded!" should be displayed

  @FilenotUploadAlert
  Scenario: Display alert when submitting without selecting a file
    Given User is on the file upload page
    When User clicks the submit button without selecting a file
    Then An non submission alert message "You need to select a file to upload!" should be displayed
    
   @framehandling
    Scenario: Click on 'Our Products' inside iframe
    Given User navigates to the iframe page
    When User switches to the iframe
    And User clicks on "Our Products" tab
    Then "Our Products" section should be displayed
