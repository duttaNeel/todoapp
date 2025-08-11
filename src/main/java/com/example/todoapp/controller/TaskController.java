package com.example.todoapp.controller;

import com.example.todoapp.model.Task;
import com.example.todoapp.model.User;
import com.example.todoapp.repository.TaskRepository;
import com.example.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {

@Autowired
private TaskRepository taskRepo;

@Autowired
private UserRepository userRepo;

@GetMapping
public List<Task> getAllTasks(@RequestParam String username) {
    User user = userRepo.findByUsername(username);
    return taskRepo.findByUser(user);
}

@GetMapping("/completed")
public List<Task> getCompletedTasks(@RequestParam String username) {
    User user = userRepo.findByUsername(username);
    return taskRepo.findByUserAndCompleted(user, true);
}

@GetMapping("/incomplete")
public List<Task> getIncompleteTasks(@RequestParam String username) {
    User user = userRepo.findByUsername(username);
    return taskRepo.findByUserAndCompleted(user, false);
}

@PostMapping
public Task createTask(@RequestParam String username, @RequestBody Task task) {
    User user = userRepo.findByUsername(username);
    task.setUser(user);
    return taskRepo.save(task);
}

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestParam String username, @RequestBody Task taskDetails) {
        Task task = taskRepo.findById(id).orElseThrow();
        if (!task.getUser().getUsername().equals(username)) {
            throw new RuntimeException("Not allowed");
        }
        task.setTitle(taskDetails.getTitle() != null ? taskDetails.getTitle() : task.getTitle());
        task.setDescription(taskDetails.getDescription() != null ? taskDetails.getDescription() : task.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        task.setPriority(taskDetails.getPriority() != null ? taskDetails.getPriority() : task.getPriority());
        task.setDueDate(taskDetails.getDueDate() != null ? taskDetails.getDueDate() : task.getDueDate());
        task.setCategory(taskDetails.getCategory() != null ? taskDetails.getCategory() : task.getCategory());
        return taskRepo.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id, @RequestParam String username) {
        Task task = taskRepo.findById(id).orElseThrow();
        if (!task.getUser().getUsername().equals(username)) {
            throw new RuntimeException("Not allowed");
        }
        taskRepo.deleteById(id);
    }
}
