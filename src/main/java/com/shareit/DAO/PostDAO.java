package com.shareit.DAO;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shareit.Entity.Post;

@Repository
public class PostDAO {
	
	private static Map<Integer, Post> posts;

}
