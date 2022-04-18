package com.example.webapi.Controller;

import com.example.webapi.Model.StudentModel;
import com.example.webapi.SecurityConfig.SecurityConfiguration;
import com.example.webapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    SecurityConfiguration securityConfiguration;

    @GetMapping("/")
    //list ma pathako sab model ma gayera basxa
    public String homePage(Model model){
        List<StudentModel> students = studentService.getStudents();
        model.addAttribute("studentlist", students);
        return "index";
    }

    @GetMapping("/new")
    public String addStudents(Model model){

        StudentModel studentModel = new StudentModel();
        model.addAttribute("student",studentModel);


        return "new";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(name = "id") int id){

        studentService.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("Student") StudentModel studentModel){

        String rawPassword = studentModel.getPassword();
        studentService.saveUser(studentModel);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")

    public ModelAndView edit(@PathVariable(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("new");

        StudentModel studentModel = studentService.findStudent(id);
        modelAndView.addObject("student", studentModel);

        return modelAndView;
    }

}

