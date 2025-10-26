package com.mentorshipportal.service;

import com.mentorshipportal.model.Mentor;
import com.mentorshipportal.repository.MentorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Mentor addMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }
}
