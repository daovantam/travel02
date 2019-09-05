package com.daovantam.travel02.service.impl;

import com.daovantam.travel02.entity.Role;
import com.daovantam.travel02.entity.User;
import com.daovantam.travel02.mapper.UserMapper;
import com.daovantam.travel02.model.request.UserRequest;
import com.daovantam.travel02.repository.RoleReposirory;
import com.daovantam.travel02.repository.UserRepository;
import com.daovantam.travel02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleReposirory roleReposirory;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleReposirory roleReposirory, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.roleReposirory = roleReposirory;
    }

    @Override
    public void insert(UserRequest userRequest) {
        User user = userMapper.tranferToUser(userRequest);
        for (Long id : userRequest.getIds()) {
            Role role = roleReposirory.getOne(id);
            user.getRoles().add(role);
        }
        userRepository.save(user);
    }

    @Override
    public void update(Long id, UserRequest userRequest) {
        Optional<User> userExist = userRepository.findById(id);
        User newUser = userMapper.tranferToUser(userRequest);
        newUser.setStatus(userExist.get().isStatus());
        newUser.setId(id);

        for (Long i : userRequest.getIds()) {
            Role role = roleReposirory.getOne(i);
            newUser.getRoles().add(role);
        }

        userRepository.save(newUser);
    }

    @Override
    public void delete(Long id) {
        Optional<User> userExist = userRepository.findById(id);

    }
}
