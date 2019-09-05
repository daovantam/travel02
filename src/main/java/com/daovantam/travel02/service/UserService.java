package com.daovantam.travel02.service;

import com.daovantam.travel02.model.request.UserRequest;

public interface UserService {

    void insert(UserRequest userRequest);

    void update(Long id, UserRequest userRequest);

    void delete(Long id);
}
