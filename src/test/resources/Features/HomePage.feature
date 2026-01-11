Feature: Home Page of sauce lab
Background: Loigin to the application
  Given User launches the Sauce application
  When User submits the valid credentials
  Then User navigates to the home page

  Scenario:  Verify add to cart scenario
    When User add the "Sauce Labs Backpack" to the cart
    Then User should see the Remove option for the item added to cart "Sauce Labs Backpack"
    And User verifies number of items added to cart
