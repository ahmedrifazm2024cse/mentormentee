package com.mentorshipportal.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allocationId;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "mentee_id")
    private Mentee mentee;

    private LocalDateTime allocatedOn = LocalDateTime.now();
}
