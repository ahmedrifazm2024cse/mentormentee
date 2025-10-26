package com.mentorshipportal.service;

import com.mentorshipportal.model.Allocation;
import com.mentorshipportal.model.Mentor;
import com.mentorshipportal.model.Mentee;
import com.mentorshipportal.repository.AllocationRepository;
import com.mentorshipportal.repository.MentorRepository;
import com.mentorshipportal.repository.MenteeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationService {

    private final AllocationRepository allocationRepository;
    private final MentorRepository mentorRepository;
    private final MenteeRepository menteeRepository;

    public AllocationService(AllocationRepository allocationRepository,
                             MentorRepository mentorRepository,
                             MenteeRepository menteeRepository) {
        this.allocationRepository = allocationRepository;
        this.mentorRepository = mentorRepository;
        this.menteeRepository = menteeRepository;
    }

    public Allocation allocate(Long mentorId, Long menteeId) {
        Mentor mentor = mentorRepository.findById(mentorId)
                .orElseThrow(() -> new RuntimeException("Mentor not found"));
        Mentee mentee = menteeRepository.findById(menteeId)
                .orElseThrow(() -> new RuntimeException("Mentee not found"));

        // Check mentor capacity
        List<Allocation> currentAllocations = allocationRepository.findByMentor_MentorId(mentorId);
        if (currentAllocations.size() >= mentor.getMaxMentees()) {
            throw new RuntimeException("Mentor has reached max mentee limit");
        }

        Allocation allocation = new Allocation();
        allocation.setMentor(mentor);
        allocation.setMentee(mentee);
        return allocationRepository.save(allocation);
    }

    public List<Allocation> getMenteesByMentor(Long mentorId) {
        return allocationRepository.findByMentor_MentorId(mentorId);
    }

    public List<Allocation> getMentorByMentee(Long menteeId) {
        return allocationRepository.findByMentee_MenteeId(menteeId);
    }
}
