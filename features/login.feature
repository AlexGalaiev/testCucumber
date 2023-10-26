Feature: login feature

  Scenario Outline: login to platform
    Given Open paltform
    Then I go to create user accont form
    Then I fill registartion form with random credentials
    And Should be text on page <msg>
    Examples:
    |msg|
    |Thank you for registering with Main Website Store.|
