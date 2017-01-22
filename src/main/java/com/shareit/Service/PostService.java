package com.shareit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shareit.Repository.PostRepository;
import com.shareit.Entity.Post;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Object findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(Long id){
		return postRepository.findOne(id);
	}
	
	public Post save(Post post){
		return postRepository.save(post);
	}
	
	public void delete(Post post){
		postRepository.delete(post);
		return;
	}

}
