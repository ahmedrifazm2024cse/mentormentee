package com.mentorshipportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mentorshipportal.model.MentorshipSession;
import java.util.List;

public interface MentorshipSessionRepository extends JpaRepository<MentorshipSession, Long> {

    // Find all sessions for an allocation
    List<MentorshipSession> findByAllocation_AllocationId(Long allocationId);
}
