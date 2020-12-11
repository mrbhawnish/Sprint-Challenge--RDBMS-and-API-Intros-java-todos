package com.lambdaschool.todos.services;


import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.EncodingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    TodoRepository todosrepos;

    @Override
    public void markComplete(long id) throws EntityNotFoundException
    {
        Todo todo = todosrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Todo " + id + "NOT FOUND"));

        todo.setCompleted(true);
    }




}
