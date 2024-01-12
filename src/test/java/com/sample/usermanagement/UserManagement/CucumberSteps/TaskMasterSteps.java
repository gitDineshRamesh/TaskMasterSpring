package com.sample.usermanagement.UserManagement.CucumberSteps;

import com.sample.usermanagement.UserManagement.Entity.TaskMaster;
import com.sample.usermanagement.UserManagement.Service.TaskService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TaskMasterSteps {
    @Autowired

    private TaskService taskService;

    private TaskMaster newTask;

    private TaskMaster updateTask;
    private List<TaskMaster> lstTaskMaster;

    private String deleteUUID;

    private boolean result;
    @Given("the user wants to add a new task")
    public void usersAddsNewTask(){
        newTask = new TaskMaster();
        newTask.setEmployeeName("iCucumber");
        newTask.setProjectName("InHouseTraining");
        newTask.setTaskDate(LocalDate.now());
        newTask.setTaskDetails("Cucumber Test Insert");
        newTask.setHoursSpent(9F);
    }
    @When("the user submits a new task with details")
    public void userSubmitsNewTaskWithDetails() {
        taskService.insertTask(newTask);
    }
    @Then("the task should be added successfully")
    public void taskShouldBeAddedSuccessfully() {
        List<TaskMaster> allTasks = taskService.getAllTask();
        Optional<TaskMaster> optionalTask = allTasks.stream()
                .filter(t -> t.getId().equals(newTask.getId()))
                .findFirst();
        assertTrue(optionalTask.isPresent());
        TaskMaster retrievedTask = optionalTask.get();
    }

    @Given("there are existing tasks")
    public void existingTasks(){
        int size = taskService.getAllTask().size();
        assertTrue(size > 0);
    }
    @When("the user requests all tasks")
    public void userReqForTasks(){
        lstTaskMaster = taskService.getAllTask();
    }
    @Then("all tasks should be returned")
    public void tasksReturn(){
        assertNotNull(lstTaskMaster);
    }

    @Given("task exist which user wants to update")
    public void taskExists(){
        updateTask = new TaskMaster();
        updateTask.setId(UUID.fromString("0f745cce-2da7-4d8d-8282-e71725f99806"));
        updateTask.setTaskDetails("Cucumber Test Update");
        updateTask.setTaskDate(LocalDate.parse("2024-01-08"));
        updateTask.setEmployeeName("dinesh");
        updateTask.setHoursSpent(9.0F);
        updateTask.setProjectName("InHouseTraining");

        assertNotNull(updateTask);
        var exists = taskService.getAllTask().stream()
                .anyMatch(t->t.getId().equals(updateTask.getId()));
        assertTrue(exists);
    }
    @When("the user submit task details to update the tasks")
    public void userUpdatesTask(){
       var update = taskService.updateTask(updateTask);
       if(update != null){
           result = true;
       }
    }
    @Then("the task should be updated successfully")
    public void taskUpdates(){
        assertTrue(result);
    }

    @Given("task exist which user wants to delete")
    public void userDeletesTask(){
        deleteUUID = taskService.getAllTask().getLast().getId().toString();
        var exists = taskService.getAllTask().stream()
                .anyMatch(t->t.getId().toString().equals(deleteUUID));
        assertTrue(exists);
    }
    @When("the user deletes the task")
    public void deleteTask(){
        taskService.deleteTask(UUID.fromString(deleteUUID));
    }
    @Then("the task should be deleted successfully")
    public void isDeleted(){
        var tm = taskService.getAllTask().stream()
                .anyMatch(x->x.getId().toString().equals(deleteUUID));
        assertFalse(tm);
    }

}
