package com.example.app1.model;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

public class User {

	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	private Address address;

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
