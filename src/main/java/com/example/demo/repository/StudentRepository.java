package com.example.demo.repository;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jhkj
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    /**
     * asdad
     * @param id
     * @return
     */
    @Override
    StudentEntity getById(Long id);
}
