package com.example.attendance.AttendanceRecord.service;

import com.example.attendance.AttendanceRecord.entity.AttendanceRecord;
import com.example.attendance.AttendanceRecord.repository.AttendanceRecordRepository;
import com.example.attendance.Student.entity.Student;
import com.example.attendance.Student.repository.StudentRepository;
import com.example.attendance.Session.entity.Session;
import com.example.attendance.Session.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceRecordService {

    private final AttendanceRecordRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final SessionRepository sessionRepository;

    public AttendanceRecord markAttendance(
            Long studentId,
            Long sessionId,
            String status) {

        if (!status.equalsIgnoreCase("PRESENT")
                && !status.equalsIgnoreCase("ABSENT")) {
            throw new RuntimeException(
                    "Status must be PRESENT or ABSENT"
            );
        }

        if (attendanceRepository
                .findByStudentStudentIdAndSessionSessionId(
                        studentId, sessionId
                ).isPresent()) {

            throw new RuntimeException(
                    "Attendance already marked for this student and session"
            );
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() ->
                        new RuntimeException("Session not found"));

        AttendanceRecord attendance = new AttendanceRecord();

        attendance.setStudent(student);
        attendance.setSession(session);
        attendance.setStatus(status.toUpperCase());
        attendance.setMarkedAt(LocalDateTime.now());

        return attendanceRepository.save(attendance);
    }

    public List<AttendanceRecord> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public AttendanceRecord getAttendanceById(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Attendance record not found"));
    }

    public List<AttendanceRecord> getAttendanceByStudent(
            Long studentId) {

        return attendanceRepository
                .findByStudentStudentId(studentId);
    }

    public List<AttendanceRecord> getAttendanceBySession(
            Long sessionId) {

        return attendanceRepository
                .findBySessionSessionId(sessionId);
    }

    public AttendanceRecord updateAttendance(
            Long id,
            String status) {

        if (!status.equalsIgnoreCase("PRESENT")
                && !status.equalsIgnoreCase("ABSENT")) {
            throw new RuntimeException(
                    "Status must be PRESENT or ABSENT"
            );
        }

        AttendanceRecord attendance =
                attendanceRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Attendance record not found"));

        attendance.setStatus(status.toUpperCase());
        attendance.setMarkedAt(LocalDateTime.now());

        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {

        if (!attendanceRepository.existsById(id)) {
            throw new RuntimeException(
                    "Attendance record not found");
        }

        attendanceRepository.deleteById(id);
    }
}