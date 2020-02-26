@Sanity
Feature: New member registration
  

  Scenario Outline: Register with valid data
    Given Member is on NewTours Home page
    When member clicks on Register link
    And enters valid Firstname, Lastname, Phone, Email, Address, City, State, Postal code
    And enters Username, <password> and <Confirm password> on Registration page
    Then member gets success message 
    Examples: 
    	| password   | Confirm password |
			|	Password_1 | Password_1 |
			
			
			
 
