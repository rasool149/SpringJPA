package com.dailycodecuffer.spring.data.jpa.tutorial.repository;

import com.dailycodecuffer.spring.data.jpa.tutorial.entity.Guardien;
import com.dailycodecuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = new Student();
        student.setStudentId(1);
        student.setEmailId("ras@gmail.com");
        student.setFirstName("Rasool");
        student.setLastName("Sheik");
        // Set other properties if needed
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardien guardien = new Guardien();
        guardien.setEmail("taj@gmail.com");
        guardien.setName("Taj");
        guardien.setMobile("234567890");

        Student student = new Student();
        student.setStudentId(2);
        student.setFirstName("Mahesh");
        student.setEmailId("bussa@gmail.com");
        student.setLastName("Bussa");
        student.setGuardien(guardien);
        // Set other properties if needed
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList = " + studentList);
    }

    @Test
    public void printStudentsByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Rasool");
        System.out.println("Students with first name Rasool: " + students);
    }
}
