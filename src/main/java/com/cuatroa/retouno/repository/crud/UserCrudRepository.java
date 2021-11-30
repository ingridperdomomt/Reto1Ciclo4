package com.cuatroa.retouno.repository.crud;


import com.cuatroa.retouno.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Este crud Repository me ayuda a hacer las consultas en la BD
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
