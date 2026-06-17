package com.banking.enterpriseiimplatform.model;

import jakarta.persistence.*;

@Entity @Table(name = "permissions")
public class Permission {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String resource;
    private String action;

    public Permission() {}
    public Permission(String name, String resource, String action) {
        this.name = name; this.resource = resource; this.action = action;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getResource() { return resource; }
    public String getAction() { return action; }
}
