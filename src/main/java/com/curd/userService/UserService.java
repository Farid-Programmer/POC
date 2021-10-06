package com.curd.userService;

import java.util.List;

import com.curd.userEntity.User;

public interface UserService {

	public User saveUser(User user)   ;
	public User updateUser(User user);
	public List<User> searchByName(String name);
	public List<User> searchBySurname(String surname);
	public List<User> searchByPincode(String pincode);
	public List<User> getAllEmployeeListInSortedOrder(String sort);
	
	public List<User> deleteUser(Integer id,String name);
	public List<User> getAllUser();
}
