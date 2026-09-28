package com.example.attendance.Subject.service;

import com.example.attendance.Subject.entity.Subject;
import com.example.attendance.Subject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    // CREATE
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // READ ALL
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // READ BY ID
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Subject not found with ID: " + id));
    }

    // UPDATE
    public Subject updateSubject(Long id, Subject subject) {

        Subject existingSubject = getSubjectById(id);

        existingSubject.setSubjectCode(subject.getSubjectCode());
        existingSubject.setSubjectName(subject.getSubjectName());
        existingSubject.setFacultyName(subject.getFacultyName());

        return subjectRepository.save(existingSubject);
    }

    // DELETE
    public void deleteSubject(Long id) {

        Subject subject = getSubjectById(id);

        subjectRepository.delete(subject);
    }
}