package com.jpa.relation.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name="admin")

public class Admin {

	
	private String username;
	private String password;

}
