package com.mentorshipportal.service;

import com.mentorshipportal.model.Mentee;
import com.mentorshipportal.repository.MenteeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenteeService {

    private final MenteeRepository menteeRepository;

    public MenteeService(MenteeRepository menteeRepository) {
        this.menteeRepository = menteeRepository;
    }

    public Mentee addMentee(Mentee mentee) {
        return menteeRepository.save(mentee);
    }

    public List<Mentee> getAllMentees() {
        return menteeRepository.findAll();
    }
}
