package com.jash.taskservice.repository;

import com.jash.taskservice.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
