package com.ideal.partner.services;

import java.util.List;

/**
 * Created by tc2r on 12/19/19.
 */
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
