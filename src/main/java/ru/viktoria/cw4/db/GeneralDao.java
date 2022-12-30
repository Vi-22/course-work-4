package ru.viktoria.cw4.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GeneralDao<T, PK> implements Dao<T, PK> {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("cw4");
    EntityManager entityManager = factory.createEntityManager();
    @Override
    public void save(T object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }
    @Override
    public void update(T object) {
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }
    @Override
    public void remove(T object) {
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }
    @Override
    public T get(PK pk) {
        return (T) entityManager.find(this.getClass(), pk);
    }


}
