package com.banking.enterpriseiimplatform.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity @Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String passwordHash;
    private String email;
    private boolean enabled = true;
    private boolean mfaEnabled = false;
    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {}
    public User(String username, String passwordHash, String email) {
        this.username = username; this.passwordHash = passwordHash;
        this.email = email; this.createdAt = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public String getEmail() { return email; }
    public boolean isEnabled() { return enabled; }
    public boolean isMfaEnabled() { return mfaEnabled; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Set<Role> getRoles() { return roles; }
    public void setEnabled(boolean e) { this.enabled = e; }
    public void setMfaEnabled(boolean m) { this.mfaEnabled = m; }
    public void addRole(Role r) { this.roles.add(r); }
}
