package com.pk.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private Long userId; //Keep it same as departmentId
	private String firstName;
	private String lastName;
	private String email;
	private Long departmentId;		
}
