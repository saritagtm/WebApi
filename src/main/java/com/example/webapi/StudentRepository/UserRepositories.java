package com.example.webapi.StudentRepository;

import com.example.webapi.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<StudentModel, Integer> {

}

