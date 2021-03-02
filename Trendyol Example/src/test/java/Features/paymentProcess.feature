@login
  Feature: Login Feature
    Scenario: Correct Login Test
      Given I am on the homepage
      When  I click for login
      And   I fill login form
      And   I click login button
      Then  I see the homepage

      When I click on slider
      Then I see products
      And  I find broken images

      When I click first product
      And  I add product to basket
      Then I see basket page

      When I confirm basket
      And  I pay for product



