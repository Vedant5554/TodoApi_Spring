package com.example.todoapispring;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("FakeTodoService")
public class FakeTodoService implements TodoService{

    @TimeMonitor
    public String doSomething(){
        return "Something";
    } // join point
}
