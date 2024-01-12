package com.sample.usermanagement.UserManagement.Service;

import com.sample.usermanagement.UserManagement.Entity.TaskMaster;
import com.sample.usermanagement.UserManagement.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService implements iTaskService{
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskMaster> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public List<TaskMaster> getTaskByDate(LocalDate date) {
//        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        return taskRepository.findByTaskDate(date);
    }

    @Override
    public TaskMaster insertTask(TaskMaster taskMaster) {
        return taskRepository.save(taskMaster);
    }

    @Override
    public TaskMaster updateTask(TaskMaster taskMaster) {
        return taskRepository.save(taskMaster);
    }

    @Override
    public void deleteTask(UUID id) {
         taskRepository.deleteById(id);
    }
}
