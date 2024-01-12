package com.sample.usermanagement.UserManagement.Service;

import com.sample.usermanagement.UserManagement.Entity.TaskMaster;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface iTaskService {
    List<TaskMaster> getAllTask();
    List<TaskMaster> getTaskByDate(LocalDate date);
    TaskMaster insertTask(TaskMaster taskMaster);
    TaskMaster updateTask(TaskMaster taskMaster);
    void deleteTask(UUID id);

}
