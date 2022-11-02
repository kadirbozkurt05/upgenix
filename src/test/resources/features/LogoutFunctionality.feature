@logout
Feature: Posmanager and Salesmanager should be able to logout
##@UPGN-769
  Background: User is on the login page
    When user goes to login page
  @UPGN-770
  Scenario Outline: User can log out and ends up in login page
    When user enters "<valid email>" to to email input
    And user enters "<valid password>"
    And user clicks login button
    Then verify that user is on the main page and save the current url
    And user clicks the username at the top right of the page
    And user clicks Log out link
    And verify user is on the login page
    And goes to saved url from home page
    Then verify user is not logged in
    Examples:
      | valid email             | valid password |
      | salesmanager47@info.com | salesmanager   |
  @UPGN-771
  Scenario Outline: The user can not go to the home page again by clicking the step back button after successfully logged out.
    When user enters "<valid email>" to to email input
    And user enters "<valid password>"
    And user clicks login button
    Then verify that user is on the main page and save the current url
    And user clicks the username at the top right of the page
    And user clicks Log out link
    And verify user is on the login page
    And user clicks to the back button from browser
    Then verify user does not go to the home page
    And goes to saved url from home page
    Then verify user is not logged in

    Examples:
      | valid email             | valid password |
      | salesmanager47@info.com | salesmanager   |

  @UPGN-772
  Scenario Outline:The user must be logged out if the user closes the open tab
    When user enters "<valid email>" to to email input
    And user enters "<valid password>"
    And user clicks login button
    Then verify that user is on the main page and save the current url
    And user closes the all windows
    Then goes to saved url from home page
    Then verify user does not go to the home page

    Examples:
      | valid email             | valid password |
      | salesmanager47@info.com | salesmanager   |

