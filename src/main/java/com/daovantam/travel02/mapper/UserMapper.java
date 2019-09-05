package com.daovantam.travel02.mapper;

import com.daovantam.travel02.entity.User;
import com.daovantam.travel02.model.request.UserRequest;
import com.daovantam.travel02.utils.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User tranferToUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.refine(userRequest, user, BeanUtils::copyNonNull);

        return user;
    }
}
