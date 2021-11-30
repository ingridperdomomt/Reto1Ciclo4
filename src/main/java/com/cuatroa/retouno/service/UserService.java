package com.cuatroa.retouno.service;

import com.cuatroa.retouno.model.User;
import com.cuatroa.retouno.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public void save (User user){
        if (user.getId()==null){
            userRepository.save(user);
        } else if(userRepository.getUser(user.getId()).isEmpty()){
            userRepository.save(user);
        }
    }

    public boolean emailExists(String email){
        if (userRepository.emailExists(email).isEmpty()){
            return false;
        }
        return true;
    }
    /*
    * Verifica si el usuario existe.
     */
    public Optional<User> userExist (String email, String password){
        Optional<User> user = userRepository.userExist(email, password);
        if(user.isEmpty()){
            return Optional.of(new User(null,email,password,"NO DEFINIDO") );
        }
        return user;
    }

}
