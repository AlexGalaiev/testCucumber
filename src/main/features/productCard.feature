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