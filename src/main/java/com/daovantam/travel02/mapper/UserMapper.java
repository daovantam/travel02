package com.daovantam.travel02.mapper;

import com.daovantam.travel02.entity.User;
import com.daovantam.travel02.model.request.UserRequest;
import com.daovantam.travel02.model.response.RegisterResponse;
import com.daovantam.travel02.model.response.RoleResponse;
import com.daovantam.travel02.model.response.UserResponse;
import com.daovantam.travel02.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private RoleMapper roleMapper;

    public User tranferToUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.refine(userRequest, user, BeanUtils::copyNonNull);

        return user;
    }

    public UserResponse tranferToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.refine(user, userResponse, BeanUtils::copyNonNull);

        return userResponse;
    }

    public RegisterResponse transferToRegister(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        Set<RoleResponse> roleResponses = user
                .getRoles()
                .stream()
                .map(roleMapper::tranferToResponse)
                .collect(Collectors.toSet());
        BeanUtils.refine(user, registerResponse, BeanUtils::copyNonNull);
        registerResponse.setRoles(roleResponses);
        return registerResponse;
    }
}
