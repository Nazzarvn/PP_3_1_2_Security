package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IRoleService {
    List<Role> findAll();

    Role getRoleById(long id);

    Role getRoleByName(String roleName);

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteRole(long id);

    HashSet<Role> getSetOfRoles(String[] roleSet);

    Set<Role> setRoleByName(String name, String[] rolesName);
}
