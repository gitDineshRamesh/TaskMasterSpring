# InsertTask.feature

Feature: Task Management

  Scenario: Insert a task
    Given the user wants to add a new task
    When the user submits a new task with details
    Then the task should be added successfully

  Scenario: Get all tasks
    Given there are existing tasks
    When the user requests all tasks
    Then all tasks should be returned

  Scenario: Update a task
    Given task exist which user wants to update
    When the user submit task details to update the tasks
    Then the task should be updated successfully

  Scenario: Delete a task
    Given task exist which user wants to delete
    When the user deletes the task
    Then the task should be deleted successfully