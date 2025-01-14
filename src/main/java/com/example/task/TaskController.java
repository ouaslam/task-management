package com.example.task;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api")
public class TaskController {
    @Autowired
    private TaskService taskservice;
    @PostMapping("/addTask")
    public Tache createTak(@Valid @RequestBody Tache tache){
        return taskservice.createTask(tache);
    }
    @GetMapping("/getAllTasks")
    public List<Tache> getAllTasks(){
        return taskservice.getAllTasks();
    }
    @GetMapping("/Task/{id}")
    public Tache getTask(@PathVariable String id){
        return taskservice.getTask(id);
    }
    @PutMapping("updateTask/{id}")
    public Tache modifiertache(@PathVariable String id,@RequestBody Tache tache){
        return taskservice.updateTask(id,tache);

    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){
        taskservice.deleteTask(id);
    }
}
