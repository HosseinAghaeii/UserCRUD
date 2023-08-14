package co.mpj.usercrud.ws.service.impl;

import co.mpj.usercrud.config.exception.UserNameAlreadyExistException;
import co.mpj.usercrud.config.exception.UserNotFoundException;
import co.mpj.usercrud.ws.model.dto.UserDto;
import co.mpj.usercrud.ws.model.entity.User;
import co.mpj.usercrud.ws.repository.UserRepository;
import co.mpj.usercrud.ws.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User existUser = userRepository.findByUserName(userDto.getUserName());
        if (existUser != null){
            throw new UserNameAlreadyExistException();
        }
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUser(UserDto userDto) {
        User user = userRepository.findByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());
        if (user == null){
            throw new UserNotFoundException();
        }
        return modelMapper.map(user,UserDto.class);
    }
}
