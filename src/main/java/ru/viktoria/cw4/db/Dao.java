package ru.viktoria.cw4.db;

public interface Dao<T, PK> {
    abstract void save();

    abstract void update();

    abstract void remove();
    abstract T get (PK pk);
}
