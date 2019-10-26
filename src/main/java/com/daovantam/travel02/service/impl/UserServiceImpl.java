package com.daovantam.travel02.service.impl;

import com.daovantam.travel02.entity.Role;
import com.daovantam.travel02.entity.User;
import com.daovantam.travel02.mapper.UserMapper;
import com.daovantam.travel02.model.request.UserRequest;
import com.daovantam.travel02.model.response.RegisterResponse;
import com.daovantam.travel02.model.response.UserResponse;
import com.daovantam.travel02.repository.RoleRepository;
import com.daovantam.travel02.repository.UserRepository;
import com.daovantam.travel02.service.UserService;
import com.daovantam.travel02.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void insert(UserRequest userRequest) {
        User user = userMapper.tranferToUser(userRequest);
        for (Long id : userRequest.getIds()) {
            Role role = roleRepository.getOne(id);
            user.getRoles().add(role);
        }
        Date date = new Date();
        userRepository.save(user);
    }

    @Override
    public void update(Long id, UserRequest userRequest) {
        Optional<User> userExist = userRepository.findById(id);

        User newUser = userMapper.tranferToUser(userRequest);
        newUser.setStatus(userExist.get().isStatus());
        newUser.setId(id);

        for (Long i : userRequest.getIds()) {
            Role role = roleRepository.getOne(i);
            newUser.getRoles().add(role);
        }

        userRepository.save(newUser);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.getOne(id);
        for (Role role : user.getRoles()) {
            role.getUsers().remove(user);
        }
    }

    @Override
    public RegisterResponse findUserByUserName(String userName) {
        User user = userRepository.findUserByUserName(userName);
        RegisterResponse registerResponse = new RegisterResponse();
        BeanUtils.refine(user, registerResponse, BeanUtils::copyNonNull);
        return registerResponse;
    }

    @Override
    public List<UserResponse> findAll() {
        List<UserResponse> userResponses = new ArrayList<>();
        UserMapper userMapper = new UserMapper();
        List<User> users = userRepository.findAll();
        for (User user:users) {
            userResponses.add(userMapper.tranferToUserResponse(user));
        }
        return userResponses;
    }
}
