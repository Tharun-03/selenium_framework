Feature: Login to the sauce application

  Scenario: Verify login to the application using valid credentials
    Given User launches the Sauce application
    When User submits the valid credentials
    Then User navigates to the home page