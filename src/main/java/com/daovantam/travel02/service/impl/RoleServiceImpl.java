package com.daovantam.travel02.service.impl;

import com.daovantam.travel02.mapper.RoleMapper;
import com.daovantam.travel02.model.response.RoleResponse;
import com.daovantam.travel02.repository.RoleRepository;
import com.daovantam.travel02.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper){
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }


    @Override
    public List<RoleResponse> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::tranferToResponse)
                .collect(Collectors.toList());
    }
}
