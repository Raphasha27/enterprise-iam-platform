package com.banking.enterpriseiimplatform.repository;

import com.banking.enterpriseiimplatform.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, String> {
    Optional<Permission> findByName(String name);
}
