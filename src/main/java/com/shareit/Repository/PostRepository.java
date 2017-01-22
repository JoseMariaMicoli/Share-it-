package com.shareit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shareit.Entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	
}
