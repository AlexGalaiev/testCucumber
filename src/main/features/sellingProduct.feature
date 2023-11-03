Feature: Test of product card

  Background: Test of product card
    Given Open platform
    Given I go to page of product "https://magento.softwaretestingboard.com/breathe-easy-tank.html"

  Scenario Outline: User flow for buying product on platform
    Given I buy product with "<size>" "<color>" "<amount>"
    And I check minicard with preconditions "<size>" "<color>" "<amount>" "<total_price>"
    Examples:
      |size|color |amount|total_price|
      |L   |Purple|2     |$68.00     |
#    And I fill shipping form with <email> <name> <lastname> <company> <street> <city> <state> <zip> <country> <phone>
#    And I check information on shipment popup <email> <name> <lastname> <company> <street> <city> <state> <zip> <country> <phone>
#    Examples:
#      |email      |name |lastname|company|street     |city  |state   |zip   |country      |phone     |
#      |test@i.com |test |testName|IBM    |7th Avenue |London|Alaska  |02345 |United States|0987878788|
#    Then I check thank you page




