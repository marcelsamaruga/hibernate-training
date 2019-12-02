package com.mastercard.commercial.hibernatetraining.hero.repository;

import com.mastercard.commercial.hibernatetraining.hero.entity.Hero;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by e068636 on 10/29/2019.
 */
@Repository
@Transactional
public class HeroRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Hero persist(Hero hero) {
        entityManager.persist(hero);
        return hero;
    }

    public Hero merge(Hero hero) {
        return entityManager.merge(hero);
    }

    public List<Hero> findAll() {
        return entityManager.createQuery("from Hero").getResultList();
    }

}
