@test
Feature: User navigates to NuffieldHeath Website and search for local Gyms

  Scenario Outline: User searches for gym on NuffieldHealth Website
    Given user navigates to "https://www.nuffieldhealth.com/gyms"
    And the website is displayed
    And the user accepts cookies
    When user searches for gyms close to their home town "<town>"
    Then user is displayed with a list of gyms containing "<location>"
    And user is displayed with a list of gyms containing "<location2>"
    And user clicks "<location>"
    And the gym contact name is "<gym-name>"
    Examples:
      | town      | location | location2 | gym-name                       |
      | Sutton UK | cheam    | croydon   | Cheam Fitness & Wellbeing Gym  |
      | Medway UK | medway   | romford   | Medway Fitness & Wellbeing Gym |