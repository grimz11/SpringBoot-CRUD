package com.appphoto.app.ws.mobileappws.controller;

import com.appphoto.app.ws.mobileappws.service.UserService;
import com.appphoto.app.ws.mobileappws.shared.dto.UserDto;
import com.appphoto.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.appphoto.app.ws.mobileappws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public String getUser() {
        return "Get user was called";
    }
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }
    @PutMapping
    public String updateUser() {
        return "Update user was called";
    }
    @DeleteMapping
    public String deleteUser() {
        return "Delete user was called";
    }
}
