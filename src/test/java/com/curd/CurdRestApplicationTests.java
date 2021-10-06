package com.curd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.curd.userEntity.User;
import com.curd.userRepository.UserRepository;
import com.curd.userService.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
class CurdRestApplicationTests {
	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void saveUser() {
		User user = new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.saveUser(user));

	}

	@Test
	public void updateUser() {
		User user = new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.saveUser(user));
	}

	@Test
	public void searchByName() {
		String name = "Raju";
		when(userRepository.findByname(name)).thenReturn(Stream
				.of(new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020")).collect(Collectors.toList()));
		assertEquals(name, userService.searchByName(name).get(0).getName());
	}

	@Test
	public void searchBySurname() {
		String surname = "Kumar";
		when(userRepository.findByname(surname)).thenReturn(Stream
				.of(new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020")).collect(Collectors.toList()));
		assertEquals(surname, userService.searchByName(surname).get(0).getSurname());
	}

	@Test
	public void searchByPincode() {
		String pincode = "400072";
		when(userRepository.findByname(pincode)).thenReturn(Stream
				.of(new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020")).collect(Collectors.toList()));
		assertEquals(pincode, userService.searchByName(pincode).get(0).getPincode());
	}

	@Test
	public void getAllEmployeeListInSortedOrder() {
		String dob = "asending";
		when(userRepository.findAll()).thenReturn(Stream
				.of(new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020"),
						new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020"))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getAllEmployeeListInSortedOrder(dob).size());
	}

	@Test
	public void deleteUser() {
		String deleteType = "soft";
		when(userRepository.findAll()).thenReturn(Stream
				.of(new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020"),
						new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020"))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getAllEmployeeListInSortedOrder(deleteType).size());
	}

	@Test
	public void getAllUser() {
		when(userRepository.findAll()).thenReturn(Stream
				.of(new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020"),
						new User(1, "Raju", "Kumar", "400072", "10/13/1990", "10/10/2020"))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getAllUser().size());
	}

}
