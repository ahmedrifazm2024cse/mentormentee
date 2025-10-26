package com.mentorshipportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mentorshipportal.model.Allocation;
import java.util.List;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {

    // Find all mentees for a specific mentor
    List<Allocation> findByMentor_MentorId(Long mentorId);

    // Find mentor for a specific mentee
    List<Allocation> findByMentee_MenteeId(Long menteeId);
}
