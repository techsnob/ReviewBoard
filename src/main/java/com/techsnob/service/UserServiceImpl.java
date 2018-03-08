package com.techsnob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartResolver;

import com.techsnob.entities.User;
import com.tecshsnob.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    /*@Autowired
	private MultipartResolver multipartResolver;*/
    
    @Override
	public User findUserByName(String username) {
		return userRepository.findByUsername(username);
	}
    
    @Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(false);
		/*user.setPhoto(user.getPhoto());*/
		userRepository.save(user);
	}
}
