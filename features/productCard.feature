Feature: Test of product card

  Background: Test of product card
    Given I go to page of product

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