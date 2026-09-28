package com.example.attendance.Subject.repository;

import com.example.attendance.Subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}