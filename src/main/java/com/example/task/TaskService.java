package com.example.task;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskrepository;
    public Tache createTask(@Valid Tache tache){
        return taskrepository.save(tache);
    }
    public List<Tache> getAllTasks(){
        return taskrepository.findAll();
    }
    public Tache getTask(String id){
        return taskrepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
    }
    public Tache updateTask(String id,@Valid Tache tache){

        Tache task=taskrepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        task.setTitle(tache.getTitle());
        task.setDescription(tache.getDescription());
        task.setStatus(tache.getStatus());
        return taskrepository.save(task);
    }
    public void deleteTask(String id){
        if(!taskrepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        taskrepository.deleteById(id);
    }
}
