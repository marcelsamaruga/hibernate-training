package com.mastercard.commercial.hibernatetraining.hero.entity;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRenewAt() {
        return renewAt;
    }

    public void setRenewAt(Date renewAt) {
        this.renewAt = renewAt;
    }
}
