package com.daovantam.travel02.service;

import com.daovantam.travel02.entity.User;
import com.daovantam.travel02.model.request.UserRequest;
import com.daovantam.travel02.model.response.RegisterResponse;
import com.daovantam.travel02.model.response.UserResponse;

import java.util.List;

public interface UserService {

    void insert(UserRequest userRequest);

    void update(Long id, UserRequest userRequest);

    void delete(Long id);

    RegisterResponse findUserByUserName(String userName);

    List<UserResponse> findAll();



}
