package com.mentorshipportal.controller;

import com.mentorshipportal.model.Mentee;
import com.mentorshipportal.service.MenteeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mentees")
@CrossOrigin("*")
public class MenteeController {

    private final MenteeService menteeService;

    public MenteeController(MenteeService menteeService) {
        this.menteeService = menteeService;
    }

    // Add mentee
    @PostMapping
    public Mentee addMentee(@RequestBody Mentee mentee) {
        return menteeService.addMentee(mentee);
    }

    // View all mentees
    @GetMapping
    public List<Mentee> getAllMentees() {
        return menteeService.getAllMentees();
    }
}
