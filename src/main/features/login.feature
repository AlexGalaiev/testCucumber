Feature: login feature

  Background: Create new user test
    Given Open platform

  Scenario Outline:
    Then I go to create user account form
    Then I fill registration form with random credentials
    Then Should be text on page "<msg>"
    Examples:
      |msg                                               |
      |Thank you for registering with Main Website Store.|

  Scenario: Login to platform by user
    Given I login to platform by user "loginUserTest@i.ua"
    And Next string must displayed "Welcome, test test!"

