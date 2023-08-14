package co.mpj.usercrud.ws.controller;

import co.mpj.usercrud.ws.model.dto.UserDto;
import co.mpj.usercrud.ws.model.request.CreatUserRequest;
import co.mpj.usercrud.ws.model.request.GetUserRequest;
import co.mpj.usercrud.ws.model.response.UserResponse;
import co.mpj.usercrud.ws.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;
    private ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("user")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreatUserRequest userRequest){
        UserDto userDto = modelMapper.map(userRequest, UserDto.class);
        UserDto savedUser = userService.createUser(userDto);
        UserResponse returnValue = modelMapper.map(savedUser,UserResponse.class);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @GetMapping("user")
    public ResponseEntity<UserResponse> getUser(@RequestBody GetUserRequest userRequest){
        UserDto userDto = modelMapper.map(userRequest,UserDto.class);
        UserDto responseUser = userService.getUser(userDto);
        UserResponse returnValue = modelMapper.map(responseUser, UserResponse.class);
        return ResponseEntity.ok(returnValue);
    }
}
