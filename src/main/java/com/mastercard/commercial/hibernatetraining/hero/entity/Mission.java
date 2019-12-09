package com.mastercard.commercial.hibernatetraining.hero.entity;

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
@Entity
@Table
public class Mission extends BaseEntity {

    //private List<Hero> heroList;

    @Column
    private String name;

    @Column
    @Temporal(TemporalType.DATE)
    private Date created;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
