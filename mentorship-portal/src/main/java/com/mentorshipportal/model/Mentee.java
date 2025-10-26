package com.mentorshipportal.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Mentee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menteeId;

    private String name;

    @Column(unique = true)
    private String email;

    private String contactNo;
    private LocalDateTime joinDate = LocalDateTime.now();
}
