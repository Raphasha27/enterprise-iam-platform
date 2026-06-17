package com.banking.enterpriseiimplatform.service;

import com.banking.enterpriseiimplatform.model.*;
import com.banking.enterpriseiimplatform.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IamService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PermissionRepository permissionRepo;

    public IamService(UserRepository ur, RoleRepository rr, PermissionRepository pr) {
        this.userRepo = ur; this.roleRepo = rr; this.permissionRepo = pr;
    }

    public User createUser(String username, String passwordHash, String email) {
        if (userRepo.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        return userRepo.save(new User(username, passwordHash, email));
    }

    public User addUserRole(String userId, String roleName) {
        User user = userRepo.findById(userId).orElseThrow();
        Role role = roleRepo.findByName(roleName).orElseThrow(() ->
            new RuntimeException("Role not found: " + roleName));
        user.addRole(role);
        return userRepo.save(user);
    }

    public Role createRole(String name, String description) {
        return roleRepo.save(new Role(name, description));
    }

    public Permission createPermission(String name, String resource, String action) {
        return permissionRepo.save(new Permission(name, resource, action));
    }

    public Role addRolePermission(String roleId, String permissionName) {
        Role role = roleRepo.findById(roleId).orElseThrow();
        Permission perm = permissionRepo.findByName(permissionName).orElseThrow();
        role.addPermission(perm);
        return roleRepo.save(role);
    }

    public User getUser(String id) { return userRepo.findById(id).orElseThrow(); }

    public List<User> getUsers() { return userRepo.findAll(); }

    public List<Role> getRoles() { return roleRepo.findAll(); }

    public User toggleMfa(String userId, boolean enabled) {
        User user = userRepo.findById(userId).orElseThrow();
        user.setMfaEnabled(enabled);
        return userRepo.save(user);
    }
}
