Feature: Test of product card

  Background: Test of product card
    Given Open platform
    Given I go to page of product "https://magento.softwaretestingboard.com/breathe-easy-tank.html"

   Scenario Outline: Check icons of product size
     Given User click on "<sizes>"
     When Users checks correct view of "<sizes>"
     Examples:
       |sizes|
       |XS|
       |S |
       |M |
       |L |
       |XL|

   Scenario Outline: Check colours of product
     Given User chose "<colour>"
     Then User check what "<colour>" is displayed
     Examples:
     |colour|
     |Purple|
     |White |
     |Yellow|

   Scenario: Сheck adding product to Wishlist
     Given I login to platform by user "loginUserTest@i.ua"
     Given I go to My Account and switch to My Wishlist
     Then Wishlist must be empty
     Given I go to page of product "https://magento.softwaretestingboard.com/breathe-easy-tank.html"
     Then I add product to wishlist
     And I check products in Wishlist


