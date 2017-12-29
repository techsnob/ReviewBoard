package com.tecshsnob.repository;

import org.springframework.data.repository.CrudRepository;

import com.techsnob.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);
}
