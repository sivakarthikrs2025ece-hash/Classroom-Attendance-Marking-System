package com.example.attendance.AttendanceRecord.controller;

import com.example.attendance.AttendanceRecord.entity.AttendanceRecord;
import com.example.attendance.AttendanceRecord.service.AttendanceRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceRecordController {

    private final AttendanceRecordService attendanceService;

    // Mark attendance
    @PostMapping
    public ResponseEntity<AttendanceRecord> markAttendance(
            @RequestParam Long studentId,
            @RequestParam Long sessionId,
            @RequestParam String status) {

        return ResponseEntity.ok(
                attendanceService.markAttendance(
                        studentId,
                        sessionId,
                        status
                )
        );
    }

    // Get all attendance records
    @GetMapping
    public ResponseEntity<List<AttendanceRecord>> getAllAttendance() {

        return ResponseEntity.ok(
                attendanceService.getAllAttendance()
        );
    }

    // Get attendance by ID
    @GetMapping("/{id}")
    public ResponseEntity<AttendanceRecord> getAttendanceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                attendanceService.getAttendanceById(id)
        );
    }

    // Get attendance by student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AttendanceRecord>> getAttendanceByStudent(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                attendanceService.getAttendanceByStudent(studentId)
        );
    }

    // Get attendance by session
    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<AttendanceRecord>> getAttendanceBySession(
            @PathVariable Long sessionId) {

        return ResponseEntity.ok(
                attendanceService.getAttendanceBySession(sessionId)
        );
    }

    // Update attendance
    @PutMapping("/{id}")
    public ResponseEntity<AttendanceRecord> updateAttendance(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                attendanceService.updateAttendance(
                        id,
                        status
                )
        );
    }

    // Delete attendance
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAttendance(
            @PathVariable Long id) {

        attendanceService.deleteAttendance(id);

        return ResponseEntity.ok(
                "Attendance deleted successfully"
        );
    }
}