package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repository.RoleDAO;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleService implements IRoleService {

    final
    RoleDAO roleDAO;

    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public void saveRole(Role role) {
        roleDAO.save(role);
    }

    @Override
    public Role getRoleById(long id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleDAO.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleDAO.remove(id);
    }

    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleSet) {
        return roleDAO.getSetOfRoles(roleSet);
    }

    @Override
    public Set<Role> setRoleByName(String name, String[] rolesName) {
        return roleDAO.setRoleByName(name, rolesName);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDAO.getRoleByName(roleName);
    }
}
