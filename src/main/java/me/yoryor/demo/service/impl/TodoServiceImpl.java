package me.yoryor.demo.service.impl;

import com.google.common.collect.Lists;
import me.yoryor.demo.entity.Todo;
import me.yoryor.demo.service.TodoRepository;
import me.yoryor.demo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Service("todoService")
public class TodoServiceImpl implements TodoService {
  private static final Logger LOG = LoggerFactory.getLogger(TodoServiceImpl.class);

  @Autowired
  private TodoRepository todoRepository;


  @Transactional(readOnly = true)
  public List<Todo> findAll() {
    return Lists.newArrayList(todoRepository.findAll());
  }

  @Transactional(readOnly = true)
  public Todo findById(int id) {
    return todoRepository.findOne(id);
  }

  public Todo save(Todo todo) {
    return todoRepository.save(todo);
  }

  public boolean deleteById(int id) {
    try {
      todoRepository.delete(id);
    } catch (Exception e) {
      LOG.error("删除操作执行失败:　", e);
      return false;
    }
    return true;
  }
}
