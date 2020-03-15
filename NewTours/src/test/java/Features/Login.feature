Feature: Login to New Tours application
 
Background: 
			Given user is on NewTours home page 

  Scenario Outline: Login with Valid credentials
    When user enters valid <username> and <password>
    And clicks submit button
    Then user gets success message on logging in successfully
  
    Examples: 
      | username  | password |
      | WedTest   | Password_1 | 
      | Thutest   | Password_1 | 
