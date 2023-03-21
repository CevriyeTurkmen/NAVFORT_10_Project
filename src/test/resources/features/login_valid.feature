Feature: Navfort_E10 login test

  Background:
    Given user is on the login page

  @NAV10-274
  Scenario Outline:Login as a <usertype>

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

@NAV10-293
  Scenario Outline:Login with invalid credentials

    When user enters invalid "<username>" and "<password>"
    And user clicks the login button
    Then warning "<message>" should be displayed

    Examples:
      | username | password    | message                       |
      | user11   | wrong       | Invalid user name or password. |
      | wrong    | UserUser123 | Invalid user name or password. |
      | wrong    | wrong       | Invalid user name or password. |

@NAV10-295
  Scenario Outline: Login without username
    When user enters invalid "<username>" and "<password>"
    And user clicks the login button
    Then warning message should be displayed

    Examples:
      | username | password    |
      |          | UserUser123 |

@NAV10-296
  Scenario Outline: Login without username and password/password

    When user enters invalid "<username>" and "<password>"
    And user clicks the login button
    Then warning different message should be displayed

    Examples:
      | username | password |
      |          |          |
      | user11   |          |

 @NAV10-297
  Scenario Outline: User displays on his own name in the profile menu

    When Log in as a "<usertype>"
    And user enters username "<username>"
    And user enters password "<password>"
    And user clicks the login button
    Then user displays on his own "<username>"

    Examples:
      | usertype      | username        | password    | username        |
      | driver        | user1           | UserUser123 | user1           |
      | sales manager | salesmanager101 | UserUser123 | salesmanager101 |
      | store manager | storemanager51  | UserUser123 | storemanager51  |