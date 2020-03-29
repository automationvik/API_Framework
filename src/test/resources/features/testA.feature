Feature: Test ALL endpoints with status code 

Scenario: Test endpoints for status code with 200 
	Given I have an endpoint 'http://localhost:8080/greeting' 
	When I set the headers as: 
		|accept|application/json|
	And I send a GET request 
	Then I should get response status code as 200 
	And I have "content" key with value as "Hello, World!" in response 
