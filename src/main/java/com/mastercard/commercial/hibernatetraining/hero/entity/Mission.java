package com.mastercard.commercial.hibernatetraining.hero.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Created by e068636 on 10/29/2019.
 */
@Data
@ToString(exclude = "heroList")
@Entity
@Table
public class Mission extends BaseEntity {

    @ManyToMany(mappedBy = "missionList")
    private List<Hero> heroList;

    @Column
    private String name;

    @Column
    @Temporal(TemporalType.DATE)
    private Date created;

}
