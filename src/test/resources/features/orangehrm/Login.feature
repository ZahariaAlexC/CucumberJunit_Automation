Feature: Login
  Scenario Outline: Check login page
    Given Navigate to OrangeHRM
    When  Fill in <username>
    Then  Add <password>
    Then  Press Login button
    Examples:
      | username | password |
      | admin    | admin123 |