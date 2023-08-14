package co.mpj.usercrud.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserNameAlreadyExistException extends RuntimeException{
    public UserNameAlreadyExistException(){
        super("This username is already used");
    }
}
