package com.appphoto.app.ws.mobileappws.controller;

import com.appphoto.app.ws.mobileappws.exceptions.UserServiceException;
import com.appphoto.app.ws.mobileappws.service.AddressService;
import com.appphoto.app.ws.mobileappws.service.UserService;
import com.appphoto.app.ws.mobileappws.shared.dto.AddressDto;
import com.appphoto.app.ws.mobileappws.shared.dto.UserDto;
import com.appphoto.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.appphoto.app.ws.mobileappws.ui.model.response.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @GetMapping(path="/{id}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUser(@PathVariable String id) {
        UserRest returnValue = new UserRest();
        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto, returnValue);

        return returnValue;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception{
        UserRest returnValue = new UserRest();
        if(userDetails.getFirstname().isEmpty() && userDetails.getLastname().isEmpty())
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FILED.getErrorMessage());

        //UserDto userDto = new UserDto();
        //BeanUtils.copyProperties(userDetails, userDto);
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto createdUser = userService.createUser(userDto);
        returnValue = modelMapper.map(createdUser, UserRest.class);

        return returnValue;
    }

    @PutMapping(path="/{id}",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@RequestBody UserDetailsRequestModel userDetails, @PathVariable String id) {
        UserRest returnValue = new UserRest();
        if(userDetails.getFirstname().isEmpty() && userDetails.getLastname().isEmpty())
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FILED.getErrorMessage());

        //UserDto userDto = new UserDto();
        //BeanUtils.copyProperties(userDetails, userDto);
        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto updatedUser = userService.updateUser(id,userDto);
        BeanUtils.copyProperties(updatedUser, returnValue);

        return returnValue;
    }

    @DeleteMapping(path="/{id}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public OperationStatusModel deleteUser(@PathVariable String id) {
        OperationStatusModel returnValue = new OperationStatusModel();

        userService.deleteUser(id);

        returnValue.setOperationName(RequestOperationName.DELETE.name());
        returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());

        return returnValue;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<UserRest> getUsers(@RequestParam(value="page", defaultValue = "0") int page, @RequestParam(value=
            "page", defaultValue = "25") int limit) {
        List<UserRest> returnValue = new ArrayList<>();

        List<UserDto> users = userService.getUsers(page, limit);

        for (UserDto userDto : users) {
            UserRest userModel = new UserRest();
            BeanUtils.copyProperties(userDto, userModel);
            returnValue.add(userModel);
        }

        return returnValue;
    }

    @GetMapping(path="/{id}/addresses", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<AddressRest> getUserAddresses(@PathVariable String id) {
        List<AddressRest> returnValue = new ArrayList<>();
        List<AddressDto> addressDto = addressService.getAddresses(id);

        if(addressDto != null && !addressDto.isEmpty()) {
            java.lang.reflect.Type listType = new TypeToken<List<AddressRest>>() {
            }.getType();
            returnValue = new ModelMapper().map(addressDto, listType);
        }
        return returnValue;
    }

    @GetMapping(path="/{id}/addresses/{addressId}", produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public AddressRest getUserAddress(@PathVariable String addressId) {
        AddressDto addressDto = addressService.getAddress(addressId);

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(addressDto, AddressRest.class);
    }
}
