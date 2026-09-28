package com.example.attendance.Session.service;

import com.example.attendance.Session.entity.Session;
import com.example.attendance.Session.repository.SessionRepository;
import com.example.attendance.Subject.entity.Subject;
import com.example.attendance.Subject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final SubjectRepository subjectRepository;

    // CREATE SESSION
    public Session createSession(
            Session session,
            Long subjectId) {

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Subject not found with ID: " + subjectId));

        session.setSubject(subject);

        return sessionRepository.save(session);
    }

    // READ ALL
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    // READ BY ID
    public Session getSessionById(Long id) {

        return sessionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Session not found with ID: " + id));
    }

    // UPDATE
    public Session updateSession(
            Long id,
            Session session,
            Long subjectId) {

        Session existingSession = getSessionById(id);

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Subject not found with ID: " + subjectId));

        existingSession.setSessionDate(
                session.getSessionDate());

        existingSession.setStartTime(
                session.getStartTime());

        existingSession.setEndTime(
                session.getEndTime());

        existingSession.setSubject(subject);

        return sessionRepository.save(existingSession);
    }

    // DELETE
    public void deleteSession(Long id) {

        Session session = getSessionById(id);

        sessionRepository.delete(session);
    }
}