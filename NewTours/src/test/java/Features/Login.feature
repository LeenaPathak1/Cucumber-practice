
Feature: Login to NewTours
 
Background:
Given Member is on NewTours home page

  @Sanity
  Scenario Outline: Login with valid credentials  
    When user enters valid <username> and <password> to login
    And user clicks submit
    Then user is logged in and gets success message 

    Examples: 
      | username  | password | 
      | WedTest |     Password_1 | 
      | WedTest2 |     Password_1 |
