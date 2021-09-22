package com.example.demo.controller;

import com.example.demo.entity.StudentDto;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public StudentEntity save(@RequestBody StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }

    @PutMapping("/update")
    public StudentEntity update(@RequestBody StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        studentRepository.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<StudentEntity> findAll(){
        List<StudentDto> dtos = new ArrayList<>();
        List<StudentEntity> list = studentRepository.findAll();
        System.out.println(dtos);
        return studentRepository.findAll();
    }

    @GetMapping("getById/{id}")
    public StudentEntity getById(@PathVariable("id") Long id){
        StudentEntity byId = studentRepository.getById(id);
        return studentRepository.getById(id);
    }
}
