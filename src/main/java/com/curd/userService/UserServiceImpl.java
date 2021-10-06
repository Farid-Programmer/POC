package com.curd.userService;

import java.util.Collections;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.curd.userEntity.User;
import com.curd.userRepository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) 
	{
		if(user!=null)
		{
		userRepository.save(user);
		}
		else {
			throw new UserNotFound("Object Not Found Exception");
		}
		return user;
	}

	@Override
	public User updateUser(User user) {

		if(user!=null)
		{
		 userRepository.save(user);
		}
		else {
			throw new UserNotFound("Unable to update Data");
		}
		
		return user;
	}

	@Override
	public List<User> searchByName(String name) {
		// TODO Auto-generated method stub
        List<User> findByname = userRepository.findByname(name);
		return findByname;
	}

	@Override
	public List<User> searchBySurname(String surname) {
		// TODO Auto-generated method stub
		List<User> findBysurname = userRepository.findBysurname(surname);
		return findBysurname;
	}

	@Override
	public List<User> searchByPincode(String pincode) {
		// TODO Auto-generated method stub
		List<User> findBypincode = userRepository.findBypincode(pincode);
		return findBypincode;
	}

	@Override
	public List<User> getAllEmployeeListInSortedOrder(String sort) {
		// TODO Auto-generated method stub
		List<User> allUser = userRepository.findAll();
		if(sort.equals("dob"))
		{
			Collections.sort(allUser,(c1,c2)->c2.getDob().compareTo(c1.getDob()));
		}
		else if (sort.equals("doj")) {
			Collections.sort(allUser,(c1,c2)->c1.getDoj().compareTo(c2.getDoj()));
		}
		
		return allUser;
	}

	@Override
	public List<User> deleteUser(Integer id, String name) {
		// TODO Auto-generated method stub
		List<User> allList = userRepository.findAll();
		if(name.equals("soft"))
		{  
		List<User> softDeletedList = allList.stream().filter(x->x.getId()!=id).collect(Collectors.toList());
		return softDeletedList;	
		}
		else if (name.equals("hard")) {
			userRepository.deleteById(id);
			List<User> hardDeleteList = userRepository.findAll();
			return hardDeleteList;
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}
	
	
	

}
