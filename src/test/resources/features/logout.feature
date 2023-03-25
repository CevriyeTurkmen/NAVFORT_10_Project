@NAV10-426
Feature: Navfort_E10 logout test

  @NAV10-424
  Scenario Outline: "<usertype>" logs out using the logout button

    Given <usertype> is on the login page by entering "<username>" and "<password>"
    When <usertype> goes to the profile menu and clicks the button
    And <usertype> displays logout button and clicks the button
    Then <usertype> lands on the login page

    Examples:

      | usertype      | username        | password    |
      | driver        | user1           | UserUser123 |
      | sales manager | salesmanager101 | UserUser123 |
      | store manager | storemanager51  | UserUser123 |

@NAV10-425
  Scenario: User should not go home page after loging out

    When user logs out
    And user clicks the step back button
    Then user should not go to homepage

