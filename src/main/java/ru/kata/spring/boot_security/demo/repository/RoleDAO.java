package ru.kata.spring.boot_security.demo.repository;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAO {

    @PersistenceContext
    EntityManager em;

    public List<Role> findAll() {
        return em.createQuery("from Role", Role.class).getResultList();
    }

    public Role getRoleById(long id) {
        return (Role) em.createQuery("from Role r where r.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    public Role getRoleByName(String roleName) {

        return (Role) em.createQuery("from Role r where r.role=:role")
                .setParameter("role", roleName)
                .getSingleResult();
    }

    public void save(Role role) {
        em.persist(role);
    }

    public void update(Role role) {
        em.merge(role);
    }

    public void remove(long id) {
        em.remove(getRoleById(id));
    }

    public HashSet<Role> getSetOfRoles(String[] rolesNames) {
        HashSet<Role> roleSet = new HashSet<>();
        for (String role : rolesNames) {
            roleSet.add(getRoleByName(role));
        }
        return roleSet;
    }

    public Set<Role> setRoleByName(String name, String[] rolesName) {
        Set<Role> roleSet = new HashSet<>();
        if (rolesName != null) {
            for (String roleName : rolesName) {
                roleSet.add(getRoleByName(roleName));
            }
        }
        return roleSet;
    }



}
