package com.mentorshipportal.controller;

import com.mentorshipportal.model.Allocation;
import com.mentorshipportal.service.AllocationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/allocations")
@CrossOrigin("*")
public class AllocationController {

    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    // Allocate a mentee to a mentor
    @PostMapping
    public Allocation allocate(@RequestParam Long mentorId, @RequestParam Long menteeId) {
        return allocationService.allocate(mentorId, menteeId);
    }

    // View mentees assigned to a mentor
    @GetMapping("/mentor/{id}")
    public List<Allocation> getMenteesByMentor(@PathVariable Long id) {
        return allocationService.getMenteesByMentor(id);
    }

    // View mentor assigned to a mentee
    @GetMapping("/mentee/{id}")
    public List<Allocation> getMentorByMentee(@PathVariable Long id) {
        return allocationService.getMentorByMentee(id);
    }
}
