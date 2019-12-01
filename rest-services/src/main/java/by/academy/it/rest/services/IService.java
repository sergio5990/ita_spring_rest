package by.academy.it.rest.services;

import java.io.Serializable;

public interface IService<T> {
    T add(T t);

    T update(T t);

    T get(Serializable id);

    void delete(Serializable id);
}
