package cn.melon.service;

import java.util.List;

public interface BaseService<T> {

    void add(T t);

    void delete(int id);

    void update(T t);

    T select(int id);

    List<T> selectAll();

}
