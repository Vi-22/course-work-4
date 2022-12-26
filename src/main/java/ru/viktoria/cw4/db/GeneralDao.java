package ru.viktoria.cw4.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.viktoria.cw4.entity.Climber;

public class GeneralDao<T> implements Dao<T,Integer> {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("cw4");
    EntityManager entityManager = factory.createEntityManager();
    public void save() {
        entityManager.getTransaction().begin();
        entityManager.persist(this);
        entityManager.getTransaction().commit();
    }

    public void update() {
        entityManager.getTransaction().begin();
        entityManager.merge(this);
        entityManager.getTransaction().commit();
    }

    public void remove(){
        entityManager.getTransaction().begin();
        entityManager.remove(this);
        entityManager.getTransaction().commit();
    }

    @Override
    public T get(Integer integer) {
        return (T) entityManager.find(this.getClass(), integer);
    }


}
