package me.yoryor.demo.controller;

import me.yoryor.demo.entity.Todo;
import me.yoryor.demo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("/todos")
@Controller
public class TodoController {
  private final static Logger LOG = LoggerFactory.getLogger(TodoController.class);
  private TodoService todoService;

  @Autowired
  public void setTodoService(TodoService todoService) {
    this.todoService = todoService;
  }

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<Todo> list() {
    LOG.info("Listing todos");
    List<Todo> todos = todoService.findAll();
    LOG.info("todo numbers is" + todos.size());
    return todos;
  }

  @RequestMapping(value = "/{id}")
  public Todo getTodoById(Integer id) {
    return todoService.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Todo save(@RequestBody Todo todo) {
    return todoService.save(todo);
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public void delete(@RequestParam Integer id) {
    todoService.deleteById(id);
  }

}
