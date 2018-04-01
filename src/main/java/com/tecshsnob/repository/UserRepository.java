package com.tecshsnob.repository;

import org.springframework.data.repository.CrudRepository;

import com.techsnob.entities.User;
import com.techsnob.exceptions.UserNotFoundByNameException;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username) throws UserNotFoundByNameException;
}
