Feature: Fill in few text-boxes
  Scenario Outline: Complete text-boxes
    Given Navigate to TextBox option
    When  I add <fullname> and <email>
    Then  Add <currentAddress> press Submit button
    Examples:
      | fullname | email           | currentAddress |
      | gigel    | gigel@gmail.com | Timisoara, 13  |
