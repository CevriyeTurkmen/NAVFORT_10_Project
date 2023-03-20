@wip
Feature: Login with valid credentials

  Background:
    Given user is on the login page

  Scenario Outline:Log in as a <usertype>

    When Log in as a "<usertype>"
    And user enters username "<username>"
    And user enters password "<password>"
    And user clicks the login button
    Then user lands on the "<page>" page

    Examples:
      | usertype | username        | password    | page            |
      | driver   | user1           | UserUser123 | Quick Launchpad |
      | usertype | salesmanager101 | UserUser123 | Dashboard       |
      | usertype | storemanager51  | UserUser123 | Dashboard       |


