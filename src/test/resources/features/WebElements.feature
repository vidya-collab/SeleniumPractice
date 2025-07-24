@Testingwebdriveruniversity.com

Feature: Testing web Elements from above website like Checkbox,Dropdown,RadioButton,file upload,Alert,Frame,DatePicker,Action class

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

  @Datepicker
  Scenario: Select a date from the date picker
    Given User is on the Datepicker page
    When User selects date "07-01-2025"
    Then Selected date should be "07-01-2025"
    
    
  @DragAndDrop
  Scenario: Drag and drop the element
    Given User is on the Actions page
    When User drags the draggable element to the target
    Then Element should be dropped successfully

  @DoubleClick
  Scenario: Double click the yellow box
  	Given User is on the Actions page
    When User double clicks on the yellow box
    Then Color should change to green

  @MouseHover
  Scenario: Mouse hover over elements
  	Given User is on the Actions page
    When User hovers over the first, second and third elements
    Then User should see all hover responses

  @ClickAndHold
  Scenario: Click and hold the black box
  	Given User is on the Actions page
    When User clicks and holds on the black box
    Then The text should change to indicate click and hold
    
