package com.curd.usercontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curd.userEntity.User;
import com.curd.userService.UserNotFound;
import com.curd.userService.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) 
	{
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(result.getFieldErrors().iterator().next().getDefaultMessage());
		}
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Integer id, @Valid @RequestBody User user, BindingResult result)
	{
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(result.getFieldErrors().iterator().next().getDefaultMessage());
		}
		user.setId(id);	
		userService.updateUser(user);
		
		return ResponseEntity.status(HttpStatus.OK).body("User Updated");
	}
	
	
	@GetMapping("/search/{searchBy}")
	public ResponseEntity<?> search(@PathVariable("searchBy") String searchBy,@RequestParam("searchdetails") String search)
	{
		if(searchBy.equals("name"))
		{
			List<User> searchByName = userService.searchByName(search);
			System.out.println(searchByName);
			return new ResponseEntity<List<User>>(searchByName,HttpStatus.OK);
		}
		
		else if (searchBy.equals("surname")) {
			List<User> searchBySurname= userService.searchBySurname(search);
			return new ResponseEntity<List<User>>(searchBySurname,HttpStatus.OK);
		}
	
		
		else if (searchBy.equals("pincode")) {
			List<User> searchByPincode= userService.searchByPincode(search);
			return new ResponseEntity<List<User>>(searchByPincode,HttpStatus.OK);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
	}
	
	
	@GetMapping("/getList/{sort}")
	public ResponseEntity<?> getListOfEmployeeInSortedOrder(@PathVariable("sort") String sort)
	{
		List<User> allEmployeeListInSortedOrder = userService.getAllEmployeeListInSortedOrder(sort);
		return new ResponseEntity<List<User>>(allEmployeeListInSortedOrder,HttpStatus.OK);
		
	}
	
	@GetMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id,@RequestParam("deleteType") String deleteType)
	{
		
		List<User> deleteUser = userService.deleteUser(id, deleteType);
		
		return new ResponseEntity<List<User>>(deleteUser,HttpStatus.OK);
		
	} 
	
	@GetMapping("/allUser")
	public ResponseEntity<?> getAllUser()
	{
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}
	
	}
	
