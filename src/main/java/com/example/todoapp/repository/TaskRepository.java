package com.example.todoapp.repository;

import com.example.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoapp.model.User;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findByUserAndCompleted(User user, boolean completed);
}
