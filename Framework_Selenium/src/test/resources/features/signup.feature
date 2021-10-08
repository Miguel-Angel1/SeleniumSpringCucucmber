Feature: Client sign up

  Scenario: client sign up a successfully
    Given Miguel wants to have an account
    When he sends required information to get the account
    Then he should be told that the account was created

  Scenario: Client sign up failed
    Given Miguel wants to have an account
    When he sends required information to get the account
    Then he should be told that the account was not created
