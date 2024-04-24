@login

Feature: Login feature

  @student
  Scenario: Login as a student
    Given I am on the login page
    When I login as a student
    Then books should be displayed

  @studentParam
  Scenario: Login as student 27
    Given I am on the login page
    When I enter username "student27@library"
    And I enter password "libraryUser"
    And click the sign in button
    And there should be 1921 entries
    Then books should be displayed
      #number can be whatever you have there