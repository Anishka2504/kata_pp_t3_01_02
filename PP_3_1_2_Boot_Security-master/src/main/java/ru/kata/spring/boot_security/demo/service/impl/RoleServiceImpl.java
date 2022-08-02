package ru.kata.spring.boot_security.demo.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.RoleService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    //------------------------------------------------------------------

    @Override
    public Role findOne(Long id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role is not found by id " + id)
        );
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    //------forbidden operations------------------------------------------
    @Override
    public Role save(Role model) {
        throw new RuntimeException("Not allowed");
    }

    @Override
    public void delete(Long id) {
        throw new RuntimeException("Not allowed");
    }
}
