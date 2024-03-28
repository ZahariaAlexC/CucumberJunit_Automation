Feature: WebTable
  Scenario Outline: Complete webTable from DemoQA
    Given Navigate to weTable
    When  Registration a person <name> and <randomNumber>
    Then  press Submit button
    When  Check if the person is in the table
    Then  Delete current person and check it
    Examples:
      | name         | randomNumber |
      | popescugigel | 23           |