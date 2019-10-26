package com.daovantam.travel02.repository;

import com.daovantam.travel02.entity.User;
import com.daovantam.travel02.model.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserName(String userName);

    List<User> findAll();
}
