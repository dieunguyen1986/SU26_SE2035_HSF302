package org.ats.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "job_skills")
public class JobSkill {

    @Id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skill skill;

    @Id
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Job job;
}
