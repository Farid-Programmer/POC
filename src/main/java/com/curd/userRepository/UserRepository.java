package com.curd.userRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curd.userEntity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByname(String name);
	public List<User> findBysurname(String surname);
	public List<User> findBypincode(String pincode);
	
}
