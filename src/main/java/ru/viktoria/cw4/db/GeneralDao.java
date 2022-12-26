package ru.viktoria.cw4.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GeneralDao<T, PK> implements Dao<T, PK> {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("cw4");
    EntityManager entityManager = factory.createEntityManager();
    @Override
    public void save() {
        entityManager.getTransaction().begin();
        entityManager.persist(this);
        entityManager.getTransaction().commit();
    }
    @Override
    public void update() {
        entityManager.getTransaction().begin();
        entityManager.merge(this);
        entityManager.getTransaction().commit();
    }
    @Override
    public void remove() {
        entityManager.getTransaction().begin();
        entityManager.remove(this);
        entityManager.getTransaction().commit();
    }
    @Override
    public T get(PK pk) {
        return (T) entityManager.find(this.getClass(), pk);
    }


}
