package com.sample.usermanagement.UserManagement.Repository;

import com.sample.usermanagement.UserManagement.Entity.TaskMaster;
import jdk.jfr.BooleanFlag;
import jdk.jfr.Enabled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public interface TaskRepository extends JpaRepository<TaskMaster, UUID> {
    @Query(value = "SELECT * FROM tbl_task_master WHERE cast( task_date as date) = :taskDate", nativeQuery = true)
    List<TaskMaster> findByTaskDate(@Param("taskDate") LocalDate taskDate);

}
