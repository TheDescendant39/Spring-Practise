package com.SpringBootTutorial.spring.data.jpa.repository;

import com.SpringBootTutorial.spring.data.jpa.entity.Guardian;
import com.SpringBootTutorial.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("vanshpt09s@gmail.com")
                .firstName("Vansh")
                .lastName("Patel")
//                .guardianEmail("patelsudhir1965@gmail.com")
//                .guardianName("Sudhir")
//                .guardianMobile("9825164701")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("utsav.sb.patel@gmail.com")
                .name("Utsav")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("Purvam")
                .lastName("Patel")
                .emailId("purvam@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getStudentByName(){
        System.out.println(studentRepository.findByFirstName("Vansh"));
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student List:"+studentList);
    }

}