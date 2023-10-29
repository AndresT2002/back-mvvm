package com.udea.mvvc.respository;

import com.udea.mvvc.model.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository <ToDoEntity,Integer> {

    @Query("SELECT t FROM ToDoEntity t WHERE t.status = true")
    List<ToDoEntity> findAllByStatusTrue();


    @Query("SELECT t FROM ToDoEntity t WHERE t.status = false")
    List<ToDoEntity> findAllByStatusFalse();

}
