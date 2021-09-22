package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "student")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class StudentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotFound(action= NotFoundAction.IGNORE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private double score;

    @Generated(GenerationTime.INSERT)
    @Column(name = "birthday",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
