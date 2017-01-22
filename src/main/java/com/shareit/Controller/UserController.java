package com.shareit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shareit.Entity.User;
import com.shareit.Service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public Object index(){
		return userService.findAll();
	}
	
	@RequestMapping(value = "/user/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(@RequestBody User user){
		String userId = "";
		
		try {
			userService.save(user);
			userId = String.valueOf(user.getId());
		} catch (Exception e) {
			// TODO: handle exception
			return "Error creating the user: " + e.toString();
		}
		
		return "User succesfully created with id = " + userId;
	}
	
	@RequestMapping("/user/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id){
		
		try {
			User user = userService.findById(id);
			userService.delete(user);
		} catch (Exception e) {
			// TODO: handle exception
			return "Error deleting the user: " + e.toString();
		}
		
		return "User succesfully deleted!";
	}
	
	@RequestMapping("/user/get-by-email")
	@ResponseBody
	public String getByEmail(String email){
		String userId = "";
		
		try {
			User user = userService.findByEmail(email);
			userId = String.valueOf(user.getId());
		} catch (Exception e) {
			// TODO: handle exception
			return "User not found";
		}
		
		return "The user id is: " + userId;
	}
	
	@RequestMapping("/user/update/{id}")
	@ResponseBody
	public String updateUser(@RequestBody User user, @PathVariable Long id){
		
		try {
			user.setId(id);
			userService.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			return "Error updating the user: " + e.toString();
		}
		
		return "User succesfully updated!";
	}
}
