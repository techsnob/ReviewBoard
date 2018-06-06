package com.techsnob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.techsnob.entities.User;
import com.techsnob.exceptions.UserNotFoundByNameException;
import com.tecshsnob.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Environment env;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
	public User findUserByName(String username) throws UserNotFoundByNameException {
    	String[] profiles = env.getActiveProfiles();
    	for (String string : profiles) {
			if(string.equals("dev-jdbc")) {
				return new User();
			} else {
				User u = userRepository.findByUsername(username);
				if(u != null) {
					return u;
				} else {
					throw new UserNotFoundByNameException("User not found for the entered name: "+ username);
				}
			}
		}
		return null;
	}
    
    @Override
	public void saveUser(User user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(false);
		userRepository.save(user);
	}
}
