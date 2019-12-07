package com.mastercard.commercial.hibernatetraining.hero.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by e068636 on 10/30/2019.
 */
@Data
@ToString(exclude = "hero")
@Entity
@Table
public class User extends BaseEntity {

    //private Hero hero;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String username;

    @Column
    @Temporal(TemporalType.DATE)
    private Date renewAt;

}
