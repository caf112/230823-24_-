package com.todo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.app.entity.Todo;
import com.todo.app.mapper.TodoMapper;

@Controller
public class TodoController {

    @Autowired
    TodoMapper todoMapper;

    @RequestMapping(value="/")
    public String index(Model model) {

//      List<Todo> list = todoMapper.selectAll();

        List<Todo> list = todoMapper.selectTime();
        List<Todo> doneList = todoMapper.selectComplete();
        model.addAttribute("todos",list);
        model.addAttribute("doneTodos",doneList);

        return "index";
    }
    
    @RequestMapping(value="/sort")
    public String sort(Model model) {

//      List<Todo> list = todoMapper.selectAll();

        List<Todo> tlist = todoMapper.selectTitle();
        List<Todo> titleList = todoMapper.selectComplete();
        model.addAttribute("todos",tlist);
        model.addAttribute("doneTodos",titleList);

        return "index";
    }
    
    @RequestMapping(value="/job")
    public String jobindex(Model model) {

//      List<Todo> list = todoMapper.selectAll();

        List<Todo> joblist = todoMapper.jobselectTime();
        List<Todo> jobdoneList = todoMapper.jobselectComplete();
        model.addAttribute("jobs",joblist);
        model.addAttribute("doneJobs",jobdoneList);

        return "job";
    }
    
    @RequestMapping(value="/jobsort")
    public String jobsort(Model model) {

//      List<Todo> list = todoMapper.selectAll();

        List<Todo> jobtlist = todoMapper.jobselectTitle();
        List<Todo> jobtitleList = todoMapper.jobselectComplete();
        model.addAttribute("jobs",jobtlist);
        model.addAttribute("doneJobs",jobtitleList);

        return "job";
    }


    @RequestMapping(value="/add")
    public String add(Todo todo) {
        todoMapper.add(todo);
        return "redirect:/";
    }
    
    @RequestMapping(value="/jobadd")
    public String jobadd(Todo job) {
        todoMapper.jobadd(job);
        return "redirect:/";
    }

    @RequestMapping(value="/update")
    public String update(Todo todo) {
        todoMapper.update(todo);
        return "redirect:/";
    }

    @RequestMapping(value="/delete")
    public String delete() {
        todoMapper.delete();
        return "redirect:/";
    }
    

    @RequestMapping(value="/jobupdate")
    public String jobupdate(Todo job) {
        todoMapper.jobupdate(job);
        return "redirect:/";
    }
  
}