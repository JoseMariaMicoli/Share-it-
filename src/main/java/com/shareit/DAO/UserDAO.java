package com.shareit.DAO;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shareit.Entity.User;

@Repository
public class UserDAO {
	
	private static Map<Integer, User> users;

}
