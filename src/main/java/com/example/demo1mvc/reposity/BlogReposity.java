package com.example.demo1mvc.reposity;

import com.example.demo1mvc.model.blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogReposity extends JpaRepository<blog,Integer> {
}
