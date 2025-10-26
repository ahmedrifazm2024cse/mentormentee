package com.mentorshipportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mentorshipportal.model.Mentee;

public interface MenteeRepository extends JpaRepository<Mentee, Long> {
}
