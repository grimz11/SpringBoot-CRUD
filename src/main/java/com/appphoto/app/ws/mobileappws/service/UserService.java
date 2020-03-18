package com.appphoto.app.ws.mobileappws.service;

        import com.appphoto.app.ws.mobileappws.shared.dto.UserDto;
        import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  UserDto  createUser(UserDto user);
}
