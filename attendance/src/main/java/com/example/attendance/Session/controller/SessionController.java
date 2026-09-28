package com.example.attendance.Session.controller;

import com.example.attendance.Session.entity.Session;
import com.example.attendance.Session.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    // CREATE
    @PostMapping
    public ResponseEntity<Session> createSession(
            @RequestParam Long subjectId,
            @RequestBody Session session) {

        return ResponseEntity.ok(
                sessionService.createSession(
                        session,
                        subjectId));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions() {

        return ResponseEntity.ok(
                sessionService.getAllSessions());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                sessionService.getSessionById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Session> updateSession(
            @PathVariable Long id,
            @RequestParam Long subjectId,
            @RequestBody Session session) {

        return ResponseEntity.ok(
                sessionService.updateSession(
                        id,
                        session,
                        subjectId));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSession(
            @PathVariable Long id) {

        sessionService.deleteSession(id);

        return ResponseEntity.ok(
                "Session deleted successfully");
    }
}