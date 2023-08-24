package com.todo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

        List<Todo> List = todoMapper.selectTime();
        List<Todo> doneList = todoMapper.selectComplete();
        model.addAttribute("todos",List);
        model.addAttribute("doneTodos",doneList);

        return "index";
    }
    
    @RequestMapping("/sort")  
    public String sort(@ModelAttribute("sort") String sort, Model model) {

      List<Todo> doneList = todoMapper.selectComplete(); 
      
      List<Todo> List;
      
      if(sort.equals("title")) {
        List = todoMapper.selectTitle();
      } else {  
        List = todoMapper.selectTime();
      }

      model.addAttribute("todos", List);
      model.addAttribute("doneTodos", doneList);

      return "index";
    }
    
    @RequestMapping(value="/job")
    public String jobindex(Model model) {

//      List<Todo> list = todoMapper.selectAll();

        List<Todo> jobList = todoMapper.jobselectTime();
        List<Todo> jobDoneList = todoMapper.jobselectComplete();
        model.addAttribute("jobs",jobList);
        model.addAttribute("doneJobs",jobDoneList);

        return "job";
    }
    
    @RequestMapping(value="/jobsort")
    public String jobsort(Model model) {

//      List<Todo> list = todoMapper.selectAll();

        List<Todo> jobtList = todoMapper.jobselectTitle();
        List<Todo> jobtitleList = todoMapper.jobselectComplete();
        model.addAttribute("jobs",jobtList);
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
        return "redirect:/job";
    }

    @RequestMapping(value="/update")
    public String update(Todo todo) {
        todoMapper.update(todo);
        return "redirect:/";
    }
    
    @RequestMapping(value="/jobupdate")
    public String jobupdate(Todo job) {
        todoMapper.jobupdate(job);
        return "redirect:/job";
    }

    @RequestMapping(value="/delete")
    public String delete() {
        todoMapper.delete();
        return "redirect:/";
    }
    
    @RequestMapping(value="/jobdelete")
    public String jobdelete() {
        todoMapper.jobdelete();
        return "redirect:/job";
    }
    

  
}