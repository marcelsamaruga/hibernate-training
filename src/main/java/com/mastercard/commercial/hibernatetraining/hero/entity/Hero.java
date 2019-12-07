package com.mastercard.commercial.hibernatetraining.hero.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by e068636 on 10/29/2019.
 */
@Data
@ToString(exclude = "missionList")
@Entity
@Table
public class Hero extends BaseEntity {

    @ManyToMany
    @JoinTable(name = "hero_mission",
            joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Mission> missionList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(mappedBy = "hero")
    private User user;

    @Column(name = "full_name")
    private String fullName;

}
