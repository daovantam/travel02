package com.daovantam.travel02.repository;

import com.daovantam.travel02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
