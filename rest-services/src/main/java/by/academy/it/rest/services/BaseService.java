package by.academy.it.rest.services;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.academy.it.rest.dao.Dao;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
@Transactional
public class BaseService<T> implements IService<T> {
    @Autowired
    private Dao<T> baseDao;

    @Override
    public T add(T t) {
        baseDao.add(t);
        return t;
    }

    @Override
    public T update(T t) {
        return baseDao.update(t);
    }

    @Override
    public T get(Serializable id) {
        return baseDao.get(id);
    }

    @Override
    public void delete(Serializable id) {
        baseDao.delete(id);
    }
}
