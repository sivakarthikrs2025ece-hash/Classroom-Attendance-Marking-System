package com.example.attendance.Student.service;

import com.example.attendance.Student.entity.Student;
import com.example.attendance.Student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    // CREATE
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ BY ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with ID: " + id));
    }

    // UPDATE
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = getStudentById(id);

        existingStudent.setName(student.getName());
        existingStudent.setRollNumber(student.getRollNumber());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYear(student.getYear());

        return studentRepository.save(existingStudent);
    }

    // DELETE
    public void deleteStudent(Long id) {

        Student student = getStudentById(id);

        studentRepository.delete(student);
    }
}