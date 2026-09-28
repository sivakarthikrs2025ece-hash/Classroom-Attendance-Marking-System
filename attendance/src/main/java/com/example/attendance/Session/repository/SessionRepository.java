package com.example.attendance.Session.repository;

import com.example.attendance.Session.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}