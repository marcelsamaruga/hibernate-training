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
public class User extends BaseEntity {

    //private Hero hero;

    private String email;

    private String password;

    private String username;

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
