#Author: Naveen
Feature: Test the login functionality of SBN.

  Scenario: User logins with valid credentials
    Given user launches the firefox browser
    And user gives url
    When user gives the "username" and "password"
    Then user clicks the login button
    And user will create new post by clicking create option
    When user gives title "title" and description "desc" and tag "tag"
    Then user uploads pics "pic"
    And user will post the selected pic
    Then verifying the uploaded post
    And user logsout and closes the browser
