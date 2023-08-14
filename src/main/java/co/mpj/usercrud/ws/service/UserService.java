package co.mpj.usercrud.ws.service;

import co.mpj.usercrud.ws.model.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUser(UserDto user);
}
