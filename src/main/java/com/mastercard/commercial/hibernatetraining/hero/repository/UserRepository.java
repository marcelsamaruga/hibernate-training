package com.mastercard.commercial.hibernatetraining.hero.repository;

import com.mastercard.commercial.hibernatetraining.hero.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by e068636 on 11/4/2019.
 */
@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User persist(User user) {
        entityManager.persist(user);
        return user;
    }

    public List<User> findAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    public User findById(Long id) {
        return (User) entityManager
                        .createQuery("from User where hero_id = :id")
                        .setParameter("id", id)
                        .getSingleResult();
    }

}
