Feature: Navport application login test

  Background:
    Given user is on the login page


  Scenario Outline:Log in as a <usertype>

    When Log in as a "<usertype>"
    And user enters username "<username>"
    And user enters password "<password>"
    And user clicks the login button
    Then user lands on the "<page>" page


    Examples:
      | usertype      | username        | password    | page            |
      | driver        | user1           | UserUser123 | Quick Launchpad |
      | sales manager | salesmanager101 | UserUser123 | Dashboard       |
      | store manager | storemanager51  | UserUser123 | Dashboard       |


  Scenario Outline:Log in as a user

    When user enters invalid "<username>" and "<password>"
    And user clicks the login button
    Then warning "<message>" should be displayed

    Examples:
      | username | password    | message                        |
      | user11   | wrong       | Invalid user name or password. |
      | wrong    | UserUser123 | Invalid user name or password. |
      | wrong    | wrong       | Invalid user name or password. |


  Scenario Outline: Username is empty
    When user enters invalid "<username>" and "<password>"
    And user clicks the login button
    Then warning message should be displayed

    Examples:
      | username | password    |
      |          | UserUser123 |


  Scenario Outline: Username and password is empty

    When user enters invalid "<username>" and "<password>"
    And user clicks the login button
    Then warning "<message>" should be displayed

    Examples:
      | username | password | message                    |
      |          |          | Please fill in this field. |
      | user11   |          | Please fill in this field. |

  @wip
  Scenario Outline:

    When Log in as a "<usertype>"
    And user enters username "<username>"
    And user enters password "<password>"
    And user clicks the login button
    Then user sees on his own "<username>"

    Examples:
      | usertype      | username        | password    | username        |
      | driver        | user1           | UserUser123 | user1           |
      | sales manager | salesmanager101 | UserUser123 | salesmanager101 |
      | store manager | storemanager51  | UserUser123 | storemanager51  |