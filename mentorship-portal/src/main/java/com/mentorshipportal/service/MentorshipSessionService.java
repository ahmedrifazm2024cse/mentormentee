package com.mentorshipportal.service;

import com.mentorshipportal.model.Allocation;
import com.mentorshipportal.model.MentorshipSession;
import com.mentorshipportal.repository.AllocationRepository;
import com.mentorshipportal.repository.MentorshipSessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MentorshipSessionService {

    private final MentorshipSessionRepository sessionRepository;
    private final AllocationRepository allocationRepository;

    public MentorshipSessionService(MentorshipSessionRepository sessionRepository,
                                    AllocationRepository allocationRepository) {
        this.sessionRepository = sessionRepository;
        this.allocationRepository = allocationRepository;
    }

    public MentorshipSession scheduleSession(Long allocationId, LocalDateTime date, String notes) {
        Allocation allocation = allocationRepository.findById(allocationId)
                .orElseThrow(() -> new RuntimeException("Allocation not found"));

        MentorshipSession session = new MentorshipSession();
        session.setAllocation(allocation);
        session.setSessionDate(date);
        session.setNotes(notes);
        session.setStatus("Scheduled");
        return sessionRepository.save(session);
    }

    public List<MentorshipSession> getSessionsByAllocation(Long allocationId) {
        return sessionRepository.findByAllocation_AllocationId(allocationId);
    }

    public MentorshipSession completeSession(Long sessionId) {
        MentorshipSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        session.setStatus("Completed");
        return sessionRepository.save(session);
    }

    public MentorshipSession cancelSession(Long sessionId) {
        MentorshipSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        session.setStatus("Cancelled");
        return sessionRepository.save(session);
    }
}
