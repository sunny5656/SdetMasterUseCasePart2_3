
Feature: Testing HTTP GET Requests

Scenario: Verify HTTP GET request and response
  Given I have an HTTP GET request
  When I send the HTTP GET request
  Then I should receive a response with status code 200