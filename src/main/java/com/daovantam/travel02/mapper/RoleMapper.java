package com.daovantam.travel02.mapper;

import com.daovantam.travel02.entity.Role;
import com.daovantam.travel02.model.response.RoleResponse;
import com.daovantam.travel02.utils.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public RoleResponse tranferToResponse(Role role){
        RoleResponse roleResponse= new RoleResponse();
        BeanUtils.refine(role,roleResponse,BeanUtils::copyNonNull);
        return roleResponse;
    }
}
