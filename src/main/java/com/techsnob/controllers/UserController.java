package com.techsnob.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.techsnob.entities.User;
import com.techsnob.exceptions.UserNotFoundByNameException;
import com.techsnob.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestParam String username, @RequestParam String password, @RequestParam MultipartFile photo) throws IOException {
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		user.setPhoto(photo.getBytes());
		userService.saveUser(user);
		return "<br><h3>Successfully added "+user.getUsername()+"</h3><br>";
	}
	
	@RequestMapping(value="/getUser", method = RequestMethod.GET)
	@ResponseBody
	public String getUserDetails(@RequestParam String username) {
        try {
        	byte[] encodedBase64 = Base64.encodeBase64(userService.findUserByName(username).getPhoto());
			return new StringBuilder()
					.append("<img alt='img' src='data:image/jpeg;base64,")
					.append(new String(encodedBase64, "UTF-8"))
					.append("'/>").toString();
		} catch (UnsupportedEncodingException e) {
			return "Unsupported Encoding of "+e.getMessage();
		} catch (UserNotFoundByNameException e) {
			return e.getMessage();
		}
	}

}
