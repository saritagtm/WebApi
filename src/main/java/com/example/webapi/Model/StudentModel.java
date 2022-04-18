package com.example.webapi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class StudentModel {
    @Id
    @GeneratedValue


    private int id;

    private String Username;

    private String Password;



}
