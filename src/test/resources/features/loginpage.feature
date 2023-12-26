Feature: Login Functionality for OpenCart E-commerce Website


  As a user of the OpenCart website
  I want to be able to log in with my account So that
  I can access my account-related features and manage my orders

  Background :
    Given I am on the OpenCart login page


  Scenario : Successful Login with valid credentials
    Given I have entered a valid username and password
    When I click on the Login button
    Then I should be logged in successfully

    Scenario Outline: Unsuccessful Login with invalid or empty credentials
      Given I have entered invalid "<usernames>" and "<password>"
      When I click on the Login button
      Then I should see an error message indicating "<error_message>"
      Examples:
        | usernames         | password        | error_message                                          |
        | invalid@email.com | invalidPassword | Warning: No match for E-Mail Address and/ or Password. |
        | abccc             | validPassword   | Warning: No match for E-Mail Address and/ or Password. |
        | valid@email.com   | abcc            | Warning: No match for E-Mail Address and/ or Password. |


  Scenario: Navigating to the forgotten password page
    When I click on the "Forgotten Password" Link
    Then I should be redirected to the password reset page









