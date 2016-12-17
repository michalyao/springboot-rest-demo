package me.yoryor.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TODO")
public @Data
class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "COMPLETED")
  private boolean completed;

  @Column(name = "ORDERS")
  private Integer order;

  @Column(name = "URL")
  private String url;

  public static void main(String[] args) {
    Todo todo = new Todo();
    todo.setId(1);
    todo.setCompleted(false);
    todo.setTitle("a");
    System.out.println(todo);
  }
}
