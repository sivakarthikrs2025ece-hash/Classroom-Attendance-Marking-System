package com.example.attendance.Subject.controller;

import com.example.attendance.Subject.entity.Subject;
import com.example.attendance.Subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    // CREATE
    @PostMapping
    public ResponseEntity<Subject> createSubject(
            @RequestBody Subject subject) {

        return ResponseEntity.ok(
                subjectService.createSubject(subject));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {

        return ResponseEntity.ok(
                subjectService.getAllSubjects());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                subjectService.getSubjectById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(
            @PathVariable Long id,
            @RequestBody Subject subject) {

        return ResponseEntity.ok(
                subjectService.updateSubject(id, subject));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubject(
            @PathVariable Long id) {

        subjectService.deleteSubject(id);

        return ResponseEntity.ok(
                "Subject deleted successfully");
    }
}