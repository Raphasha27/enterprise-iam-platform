package com.banking.enterpriseiimplatform.controller;

import com.banking.enterpriseiimplatform.model.*;
import com.banking.enterpriseiimplatform.service.IamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class IamController {
    private final IamService service;

    public IamController(IamService service) { this.service = service; }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.createUser(
            req.get("username"), req.get("passwordHash"), req.get("email")));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok(service.getUser(id));
    }

    @PostMapping("/users/{id}/roles")
    public ResponseEntity<User> addUserRole(@PathVariable String id, @RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.addUserRole(id, req.get("roleName")));
    }

    @PostMapping("/users/{id}/mfa")
    public ResponseEntity<User> toggleMfa(@PathVariable String id, @RequestBody Map<String, Boolean> req) {
        return ResponseEntity.ok(service.toggleMfa(id, req.getOrDefault("enabled", false)));
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.createRole(req.get("name"), req.get("description")));
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(service.getRoles());
    }

    @PostMapping("/permissions")
    public ResponseEntity<Permission> createPermission(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.createPermission(
            req.get("name"), req.get("resource"), req.get("action")));
    }

    @PostMapping("/roles/{id}/permissions")
    public ResponseEntity<Role> addRolePermission(@PathVariable String id, @RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.addRolePermission(id, req.get("permissionName")));
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "UP", "service", "enterprise-iam-platform"));
    }
}
