
Feature: Logout Function


  Background:
    Given User is on the HomePage


  Scenario: The user can log out and ends up on the login page
    When User opens profile menu
    And User clicks logout link
    Then User lands on login page


  Scenario: The user can not go to the home page again by clicking the step back button
  after successfully logging out.
    When User opens profile menu
    And User clicks logout link
    And User lands on login page
    And User clicks on the step back button
    Then User can not go to homepage

  @wip
  Scenario:The user must be logged out if the user close the open tab (all tabs if there are multiple open tabs)
    When User opens two homepage tab
    And User closes all the open tabs
    And User reopen the url
    Then User can not land on the homepage