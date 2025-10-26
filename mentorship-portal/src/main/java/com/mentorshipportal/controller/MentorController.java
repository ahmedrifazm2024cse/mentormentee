package com.mentorshipportal.controller;

import com.mentorshipportal.model.Mentor;
import com.mentorshipportal.service.MentorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mentors")
@CrossOrigin("*") // allows frontend apps to access this API
public class MentorController {

    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    // Add mentor
    @PostMapping
    public Mentor addMentor(@RequestBody Mentor mentor) {
        return mentorService.addMentor(mentor);
    }

    // View all mentors
    @GetMapping
    public List<Mentor> getAllMentors() {
        return mentorService.getAllMentors();
    }
}
