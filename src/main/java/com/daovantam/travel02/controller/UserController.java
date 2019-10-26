package com.daovantam.travel02.controller;

import com.daovantam.travel02.entity.User;
import com.daovantam.travel02.model.request.UserRequest;
import com.daovantam.travel02.model.response.RegisterResponse;
import com.daovantam.travel02.model.response.UserResponse;
import com.daovantam.travel02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class UserController extends BaseController{

    private UserService userService;
    private RoleS

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Void> insert(@RequestBody UserRequest userRequest) {
        userService.insert(userRequest);
//        return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody UserRequest userRequest) {
        userService.update(id, userRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<RegisterResponse> getUserByUserName(@RequestParam String userName){
        return ResponseEntity.ok(userService.findUserByUserName(userName));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

}
