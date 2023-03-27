package com.portfolio.Portfolio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.Portfolio.Repository.TodoRepository;
import com.portfolio.Portfolio.Repository.TodoRepositoryexp;
import com.portfolio.Portfolio.model.Task;
import com.portfolio.Portfolio.model.exp;

@CrossOrigin(origins = { "https://portfolio-9bdec.web.app", "http://localhost:4200" })
@RestController
public class todocontroller {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoRepositoryexp todoRepositoryexp;

    @GetMapping(value = "/tasks")
    public List<Task> getTasks() {
        return todoRepository.findAll();
    }

    @GetMapping(value = "/exp")
    public List<exp> getExp() {
        return todoRepositoryexp.findAll();
    }

    @PostMapping(value = "/save")
    public String saveTask(@RequestBody Task task) {
        todoRepository.save(task);
        return "Saved task";
    }

    @PostMapping(value = "/save/exp")
    public String saveExp(@RequestBody exp exp) {
        todoRepositoryexp.save(exp);
        return "Saved task";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task) {
        Task updateTask = todoRepository.findById(id).get();
        updateTask.setId(task.getId());
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        todoRepository.save(updateTask);
        return "Updated Task";
    }

    @PutMapping(value = "/update/exp/{id}")
    public String updateExp(@PathVariable long id, @RequestBody exp exp) {
        exp updateExp = todoRepositoryexp.findById(id).get();
        updateExp.setId(exp.getId());
        updateExp.setTitle(exp.getTitle());
        updateExp.setDescription(exp.getDescription());
        updateExp.setWeburl(exp.getWeburl());
        updateExp.setUrl(exp.getUrl());
        updateExp.setView(exp.isView());
        todoRepositoryexp.save(updateExp);
        return "Updated Task";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id) {
        Task deletedTask = todoRepository.findById(id).get();
        todoRepository.delete(deletedTask);
        return "Deleted Task";
    }

    @DeleteMapping(value = "/delete/exp/{id}")
    public String deleteExp(@PathVariable long id) {
        exp deletedExp = todoRepositoryexp.findById(id).get();
        todoRepositoryexp.delete(deletedExp);
        return "Deleted Task";
    }
}
