package com.shareit.Service;

import org.springframework.stereotype.Service;

import com.shareit.Entity.User;
import com.shareit.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Object findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id){
		return userRepository.findOne(id);
	}
	
	public User save(User user){
		return userRepository.save(user);
	}
	
	public void delete(User user){
		userRepository.delete(user);
		return;
	}
	
	public User findByEmail(String email){
		return null;
	}

}
