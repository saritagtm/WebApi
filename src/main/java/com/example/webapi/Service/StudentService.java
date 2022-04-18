package com.example.webapi.Service;

import com.example.webapi.Model.StudentModel;
import com.example.webapi.StudentRepository.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    UserRepositories userRepositories;

    //save single user
    public StudentModel saveUser(StudentModel studentModel) {
        userRepositories.save(studentModel);
        return studentModel;
    }

    //saves multiple users it needs to be send in array
    public List<StudentModel> getStudents() {
        return userRepositories.findAll();
    }
    public String deleteById(int id) {
        userRepositories.deleteById(id);
        return "User removed !! " + id;
    }
    public StudentModel findStudent(int id){
        return userRepositories.findById(id).orElse(null);
    }
}

