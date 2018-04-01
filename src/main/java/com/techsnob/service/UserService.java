package com.techsnob.service;

import com.techsnob.entities.User;
import com.techsnob.exceptions.UserNotFoundByNameException;

public interface UserService {
	User findUserByName(String username) throws UserNotFoundByNameException;
	void saveUser(User user);
}
