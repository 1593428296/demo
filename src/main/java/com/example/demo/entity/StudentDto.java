package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;

@Data
public class StudentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private double score;

    private Date birthday;


}
