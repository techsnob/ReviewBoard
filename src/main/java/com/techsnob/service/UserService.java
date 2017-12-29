package com.techsnob.service;

import com.techsnob.entities.User;

public interface UserService {
	User findUserByName(String username);
	void saveUser(User user);
}
