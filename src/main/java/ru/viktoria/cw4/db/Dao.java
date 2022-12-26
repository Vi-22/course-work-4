package ru.viktoria.cw4.db;

public interface Dao<T, PK> {
    void save();

    void update();

    void remove();

    T get(PK pk);
}
