package com.example.todoapispring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private static List<Todo> todoList;
    public TodoController(){
        todoList = new ArrayList<>();
        todoList.add(new Todo(1,false,"Todo 1",1));
        todoList.add(new Todo(2,true,"Todo 2",2));
    }


    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.ok(todoList);
    }

    @PostMapping("/todos")

    public Todo createTodo(@RequestBody Todo newTodo){

        /*
         * @ResponseStatus(HttpStatus.CREATED) we can set this annotation to set the status code
         *
         * another way for this is
         *
         * public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
         * todoList.add(newTodo);
         * return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
         * }
         * this helps to handle manually
         */
        todoList.add(newTodo);
        return newTodo;
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable long todoId){
        for(Todo todo : todoList){
            if(todo.getId() == todoId){
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.notFound().build(); //instead of returning 404 not found we can return a json object todo not found that is the hw
    }




}
