Feature: Testing HTTP post Requests

Scenario: Verify HTTP post request and response
  Given I have an HTTP post request
  When I send the HTTP post request
  Then I will receive a response with status code 415