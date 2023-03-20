package com.portfolio.Portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.Portfolio.model.Task;

public interface TodoRepository extends JpaRepository<Task, Long> {

}
