Feature: Login page
  Scenario Outline: Validate Login page
    Given Fill in <username> and <password>
    Then  press Login button
    Examples:
      | username | password |
      | admin    | admin123 |
      | admin    | admin211 |