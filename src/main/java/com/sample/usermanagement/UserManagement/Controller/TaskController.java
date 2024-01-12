package com.sample.usermanagement.UserManagement.Controller;

import com.sample.usermanagement.UserManagement.Entity.TaskMaster;
import com.sample.usermanagement.UserManagement.Service.TaskService;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getAllTasks")
    public List<TaskMaster> getAllTasks(){
        return taskService.getAllTask();
    }

    @GetMapping("/getAllTaskByDate")
    public List<TaskMaster> getAllTaskByDate(String date){
        if (date==null || date.isBlank()){
            return null;
        }
        return taskService.getTaskByDate(LocalDate.parse(date));
    }

    @PostMapping("/InsertTask")
    public TaskMaster InsertTask(@RequestBody TaskMaster taskMaster){
        return taskService.insertTask(taskMaster);
    }

    @PutMapping("/UpdateTask")
    public TaskMaster UpdateTask(@RequestBody TaskMaster taskMaster){
        return taskService.updateTask(taskMaster);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") UUID id){
        taskService.deleteTask(id);
    }
}
