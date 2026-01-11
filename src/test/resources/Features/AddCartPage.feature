Feature: Home Page of sauce lab
  Background: Login to the application
    Given User launches the Sauce application
    When User submits the valid credentials
    Then User navigates to the home page

    Scenario: Verify addToCart page Ui layout
      When User clicks on the add to cart icon
      Then User verifies the UI layout of the add to cart page

