package com.sample.usermanagement.UserManagement.Entity;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.el.util.Validation;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tbl_TaskMaster")
@ApiModel(description = "Task details")
public class TaskMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID Id;
    @Column(name = "EmployeeName",nullable = false)
    private String EmployeeName;

    @Column(name = "TaskDate",nullable = false)
    private LocalDate TaskDate;
    @Column(name = "ProjectName",nullable = false)
    private String ProjectName;
    @Column(name = "TaskDetails",nullable = false)
    private String TaskDetails;
    @Column(name = "HoursSpent",nullable = false)
    private Float HoursSpent;

    public TaskMaster() {
    }

    public TaskMaster(UUID id, String employeeName, LocalDate taskDate, String projectName, String taskDetails, Float hoursSpent) {
        Id = id;
        EmployeeName = employeeName;
        TaskDate = taskDate;
        ProjectName = projectName;
        TaskDetails = taskDetails;
        HoursSpent = hoursSpent;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public LocalDate getTaskDate() {
        return TaskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        TaskDate = taskDate;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getTaskDetails() {
        return TaskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        TaskDetails = taskDetails;
    }

    public Float getHoursSpent() {
        return HoursSpent;
    }

    public void setHoursSpent(Float hoursSpent) {
        HoursSpent = hoursSpent;
    }
}
