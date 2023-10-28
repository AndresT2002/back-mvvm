package com.udea.mvvc.respository;

import com.udea.mvvc.model.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository <ToDoEntity,Integer>{
}
