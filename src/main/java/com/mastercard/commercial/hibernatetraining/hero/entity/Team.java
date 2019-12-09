package com.mastercard.commercial.hibernatetraining.hero.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by e068636 on 10/29/2019.
 */
public class Team extends BaseEntity {

    //private List<Hero> heroList;

    private String name;
}
