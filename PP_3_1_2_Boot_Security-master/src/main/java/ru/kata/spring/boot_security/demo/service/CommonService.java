package ru.kata.spring.boot_security.demo.service;

import java.util.List;

public interface CommonService<M> {

    M findOne(Long id);

    List<M> findAll();

    M save(M model);

    void delete(Long id);
}
