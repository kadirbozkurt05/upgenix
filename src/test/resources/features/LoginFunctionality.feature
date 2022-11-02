Feature: Posmanager and Salesmanager should login with valid credentials


  Background:User is on the main page
    When user goes to login page


  @UPGN-742
  Scenario Outline: Salesmanager can log in with valid credentials
    When salesmanager enters "<valid username>" to to email input
    And salesmanager enter "<valid password>" to password input
    And user clicks login button
    Then salesmanager should see the #Inbox - Odoo as title
    Examples:
      | valid username          | valid password |
      | salesmanager23@info.com | salesmanager   |
      | salesmanager47@info.com | salesmanager   |
      | salesmanager69@info.com | salesmanager   |
  @UPGN-743
  Scenario Outline: Salesmanager can not log in with invalid username and invalid password
    When salesmanager enters "<invalid username>" to to email input
    And salesmanager enter "<invalid password>" to password input
    And user clicks login button
    Then user should see the Wrong login password message
    Examples:
      | invalid username         | invalid password |
      | salesmanager23@gmail.com | salmanager       |
      | salesmanager35@gmail.com | lesmanager       |
      | salesmanager47@gmail.com | salesmanag       |
      | salesmanager69@gmail.com | salesmager       |
  @UPGN-744
  Scenario Outline: Salesmanager can not log in with valid username and invalid password
    When salesmanager enters "<valid username>" to to email input
    And salesmanager enter "<invalid password>" to password input
    And user clicks login button
    Then user should see the Wrong login password message
    Examples:
      | valid username        | invalid password |
      | salesmanager23@info.com | salmanager       |
      | salesmanager35@info.com | lesmanager       |
      | salesmanager47@info.com | salesmanag       |
      | salesmanager69@info.com | salesmager       |
  @UPGN-745
  Scenario Outline: Salesmanager can not log in with invalid username and valid password
    When salesmanager enters "<invalid username>" to to email input
    And salesmanager enter "<valid password>" to password input
    And user clicks login button
    Then user should see the Wrong login password message
    Examples:
      | invalid username         | valid password |
      | salesmanager23@gmail.com | salesmanager     |
      | salesmanager35@gmail.com | salesmanager     |
      | salesmanager47@gmail.com | salesmanager     |
      | salesmanager69@gmail.com | salesmanager     |




  @UPGN-746
  Scenario Outline: Posmanager can log in with valid credentials
    When posmanager enters "<valid username>" to to email input
    And posmanager enter "<valid password>" to password input
    And user clicks login button
    Then posmanager should see the #Inbox - Odoo as title
    Examples:
      | valid username        | valid password |
      | posmanager23@info.com | posmanager     |
      | posmanager35@info.com | posmanager     |
      | posmanager47@info.com | posmanager     |
      | posmanager69@info.com | posmanager     |

  @UPGN-747
  Scenario Outline: Posmanager can not log in with invalid username and invalid password
    When posmanager enters "<invalid username>" to to email input
    And posmanager enter "<invalid password>" to password input
    And user clicks login button
    Then user should see the Wrong login password message
    Examples:
      | invalid username       | invalid password |
      | posmanager23@gmail.com | pomanager        |
      | posmanager35@gmail.com | posanager        |
      | posmanager47@gmail.com | posmaager        |
      | posmanager69@gmail.com | posmanagr        |
  @UPGN-748
  Scenario Outline: Posmanager can not log in with invalid valid username and invalid password
    When posmanager enters "<valid username>" to to email input
    And posmanager enter "<invalid password>" to password input
    And user clicks login button
    Then user should see the Wrong login password message
    Examples:
      | valid username      | invalid password |
      | posmanager23@info.com | pomanager        |
      | posmanager35@info.com | posanager        |
      | posmanager47@info.com | posmaager        |
      | posmanager69@info.com | posmanagr        |


  @UPGN-749
  Scenario Outline: Posmanager can not log in with invalid username and valid password
    When posmanager enters "<invalid username>" to to email input
    And posmanager enter "<valid password>" to password input
    And user clicks login button
    Then user should see the Wrong login password message
    Examples:
      | invalid username      | valid password |
      | posmanager23@gmail.com | posmanager       |
      | posmanager35@gmail.com | posmanager       |
      | posmanager47@gmail.com | posmanager       |
      | posmanager69@gmail.com | posmanager       |

  @UPGN-750
  Scenario Outline: Salesmanager can log in with valid credentials
    When salesmanager enters "<valid username>" to to email input
    And salesmanager enter "<valid password>" to password input
    And user press Enter
    Then salesmanager should see the #Inbox - Odoo as title
    Examples:
      | valid username          | valid password |
      | salesmanager23@info.com | salesmanager   |
      | salesmanager35@info.com | salesmanager   |
      | salesmanager47@info.com | salesmanager   |
      | salesmanager69@info.com | salesmanager   |

  @UPGN-751
  Scenario Outline: Posmanager can log in with valid credentials
    When posmanager enters "<valid username>" to to email input
    And posmanager enter "<valid password>" to password input
    And user press Enter
    Then posmanager should see the #Inbox - Odoo as title
    Examples:
      | valid username        | valid password |
      | posmanager23@info.com | posmanager     |
      | posmanager35@info.com | posmanager     |
      | posmanager47@info.com | posmanager     |
      | posmanager69@info.com | posmanager     |

  @UPGN-752
    Scenario: User should see error message if leave blank email input or password input
      Then verify email input has error message attribute
      Then verify password input has error message attribute


