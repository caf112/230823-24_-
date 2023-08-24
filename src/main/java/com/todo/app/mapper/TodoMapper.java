package com.todo.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.todo.app.entity.Todo;

@Mapper
public interface TodoMapper {

//    public List<Todo> selectAll();

    public List<Todo> selectTitle();
    
    public List<Todo> selectTime();

    public List<Todo> selectComplete();
    
    public List<Todo> jobselectTitle();
    
    public List<Todo> jobselectTime();

    public List<Todo> jobselectComplete();

    public void add(Todo todo);
    
    public void jobadd(Todo job);

    public void update(Todo todo);
    
    public void jobupdate(Todo job);

    public void delete();
    
    public void jobdelete();
}

