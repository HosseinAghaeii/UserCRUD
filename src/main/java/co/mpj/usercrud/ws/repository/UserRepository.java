package co.mpj.usercrud.ws.repository;

import co.mpj.usercrud.ws.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);
    User findByUserNameAndPassword(String username,String password);
}
