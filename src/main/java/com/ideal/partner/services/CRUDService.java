package com.ideal.partner.services;

import java.util.List;

/**
 * Created by tc2r on 02/11/2020.
 */
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
