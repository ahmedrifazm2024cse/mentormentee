package com.mentorshipportal.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mentorId;

    private String name;

    @Column(unique = true)
    private String email;

    private String contactNo;
    private String specialization;
    private int maxMentees;
    private LocalDateTime joinDate = LocalDateTime.now();
}
