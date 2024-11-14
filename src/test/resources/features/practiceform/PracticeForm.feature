Feature: Practice Form
  Scenario Outline: Testing
    Given Navigate to Forms and Practice form
    When  Fill out <name> and <lastname>
    Then  Complete <email>
    When  Choose <gender>
    Then  Add <mobil> and <subjects>
    When  fill in <address> and <state>
    Then  Press button Submit
    Examples:
      | name    | lastname | email           | gender | mobil      | subjects   | address     | state |
      | popescu | gigel    | gigel@gmail.com | Male   | 0721190935 | testtestte | calarasi 10 | NCR   |