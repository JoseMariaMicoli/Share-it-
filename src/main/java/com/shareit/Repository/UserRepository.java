package com.shareit.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.shareit.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	public User findByEmail(String email);

}
