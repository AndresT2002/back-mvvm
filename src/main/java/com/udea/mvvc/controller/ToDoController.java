package com.udea.mvvc.controller;
import com.udea.mvvc.model.ToDoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.udea.mvvc.respository.ToDoRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/to-do")
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;


    //List all
    @GetMapping()
    public ResponseEntity<List<ToDoEntity>> getList(){
        return new ResponseEntity<>(toDoRepository.findAll(), HttpStatus.OK);
    }

    //Delete
    @DeleteMapping(path="/{id}")
    public ResponseEntity<ToDoEntity> deleteTask(@PathVariable("id") Integer id){
        try {
            toDoRepository.delete(toDoRepository.findById(id).get());

            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }


    }

    //Update
    @PutMapping()
    public ResponseEntity<ToDoEntity> updateTask(@RequestBody ToDoEntity toDo){

        try {
            ToDoEntity toDoFound= toDoRepository.findById(toDo.getId()).get();
            toDoFound.setName(toDo.getName());
            toDo.setDescription(toDo.getDescription());
            toDo.setStatus(toDo.getStatus());
            toDoRepository.save(toDo);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }

    //Create
    @PostMapping()
    public ResponseEntity<ToDoEntity> createToDo(@RequestBody ToDoEntity toDo){

        try {
            LocalDateTime now = LocalDateTime.now();
            Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
            toDo.setDate(date);
            return new ResponseEntity<>(toDoRepository.save(toDo), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }

    //Get ToDo by Id
    @GetMapping(path="/{id}")


    public ResponseEntity<ToDoEntity> getToDo(@PathVariable("id") Integer id){

        try {
            return new ResponseEntity<>(toDoRepository.findById(id).get() ,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }


    }



}
