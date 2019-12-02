package com.mastercard.commercial.hibernatetraining.hero.repository;

import com.mastercard.commercial.hibernatetraining.hero.entity.Mission;
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
public class MissionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Mission persist(Mission mission) {
        entityManager.persist(mission);
        return mission;
    }

    public Mission merge(Mission mission) {
        return entityManager.merge(mission);
    }

    public List<Mission> findAll() {
        return entityManager
                .createQuery("from Mission")
                .getResultList();
    }

    public Mission findById(Long id) {
        return entityManager.find(Mission.class, id);
    }

}