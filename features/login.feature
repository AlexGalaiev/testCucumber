Feature: login feature

  Scenario Outline: Create new user test
    Given Open paltform
    Then I go to create user accont form
    Then I fill registartion form with random credentials
    Then Should be text on page "<msg>"
    Examples:
    |msg                                               |
    |Thank you for registering with Main Website Store.|

  Scenario: Login to paltform by user
    Given Open paltform
    Given I login to platform by user loginUserTest@i.ua
    Given bla

