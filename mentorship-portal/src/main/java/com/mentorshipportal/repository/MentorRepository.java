package com.mentorshipportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mentorshipportal.model.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
