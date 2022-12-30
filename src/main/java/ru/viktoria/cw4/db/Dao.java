package ru.viktoria.cw4.db;

public interface Dao<T, PK> {
    void save(T object);

    void update(T object);

    void remove(T object);

    T get(PK pk);
}
