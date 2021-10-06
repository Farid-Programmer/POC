package com.curd.userEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "user_details")
@Data
@ToString
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min = 5,max = 20,message = "Name Must be between 05 to 20 characters")
	private String name;
	@NotBlank(message = "surename cant be empty")
	private String surname;
	@NotBlank(message = "pincode cant be empty")
	private String pincode;
	@NotBlank(message = "dob cant be empty")
	private String dob;
	@NotBlank(message = "doj cant be empty")
	private String doj;

}
