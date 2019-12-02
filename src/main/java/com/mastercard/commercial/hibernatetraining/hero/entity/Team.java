package com.mastercard.commercial.hibernatetraining.hero.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by e068636 on 10/29/2019.
 */
@Data
@ToString(exclude = "heroList")
@Entity
@Table
public class Team extends BaseEntity {

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Hero> heroList;

    @Column
    private String name;
}
