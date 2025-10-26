package com.mentorshipportal.controller;

import com.mentorshipportal.model.MentorshipSession;
import com.mentorshipportal.service.MentorshipSessionService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin("*")
public class MentorshipSessionController {

    private final MentorshipSessionService sessionService;

    public MentorshipSessionController(MentorshipSessionService sessionService) {
        this.sessionService = sessionService;
    }

    // Schedule a new session
    @PostMapping
    public MentorshipSession scheduleSession(@RequestParam Long allocationId,
                                             @RequestParam String date,
                                             @RequestParam String notes) {
        LocalDateTime sessionDate = LocalDateTime.parse(date);
        return sessionService.scheduleSession(allocationId, sessionDate, notes);
    }

    // View all sessions for a mentor-mentee pair
    @GetMapping("/allocation/{id}")
    public List<MentorshipSession> getSessionsByAllocation(@PathVariable Long id) {
        return sessionService.getSessionsByAllocation(id);
    }

    // Mark session as completed
    @PutMapping("/{id}/complete")
    public MentorshipSession completeSession(@PathVariable Long id) {
        return sessionService.completeSession(id);
    }

    // Cancel session
    @PutMapping("/{id}/cancel")
    public MentorshipSession cancelSession(@PathVariable Long id) {
        return sessionService.cancelSession(id);
    }
}
