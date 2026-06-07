Feature: OrangeHRM login
  Scenario: Logo presence on OrangeHRM home page
    Given I launch chrome browser
    When I open orange hrm home page
    Then I verify the logo is present on the home page
    And close the browser

