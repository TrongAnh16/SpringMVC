package com.codegym.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    //đưa entity vào để khi xóa customer sẽ chuyển deleted sang true, sẽ ko xóa dữu liệu.
    void remove(T entity);
}
