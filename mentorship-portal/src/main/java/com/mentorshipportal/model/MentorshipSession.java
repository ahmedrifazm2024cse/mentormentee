package com.mentorshipportal.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class MentorshipSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "allocation_id")
    private Allocation allocation;

    private LocalDateTime sessionDate;
    private String notes;
    private String status; // Scheduled, Completed, Cancelled
}
