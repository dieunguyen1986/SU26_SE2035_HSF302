package org.ats.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "job_skills")
public class JobSkill {

    @Id
    @Column(name = "skill_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Skill skill;

    @Id
    @Column(name = "job_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Job job;
}
