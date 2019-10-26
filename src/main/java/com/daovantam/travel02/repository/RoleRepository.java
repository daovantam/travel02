package com.daovantam.travel02.repository;

import com.daovantam.travel02.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Override
    List<Role> findAll();
}
