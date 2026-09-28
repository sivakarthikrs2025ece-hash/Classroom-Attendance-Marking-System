package com.example.attendance.AttendanceRecord.repository;

import com.example.attendance.AttendanceRecord.entity.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttendanceRecordRepository
        extends JpaRepository<AttendanceRecord, Long> {

    List<AttendanceRecord> findByStudentStudentId(Long studentId);

    List<AttendanceRecord> findBySessionSessionId(Long sessionId);

    Optional<AttendanceRecord> findByStudentStudentIdAndSessionSessionId(
            Long studentId,
            Long sessionId
    );
}