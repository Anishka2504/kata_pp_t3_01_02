package ru.kata.spring.boot_security.demo.entity.parent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class NameEntity extends BaseEntity{

    @Column
    private String name;

}
