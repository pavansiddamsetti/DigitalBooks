package com.example.app1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app1.model.Address;
import com.example.app1.model.User;

@RestController
public class UserController {
	
	@GetMapping("/user")
	public List<User> get() {
		List<User> listUser=new ArrayList();
		User usr=new User();
		usr.setDob(LocalDate.of(1994, 06, 22));
		usr.setName("kalyan");
		Address add=new Address();
		add.setCity("kasipadu");
		usr.setAddress(add);
		listUser.add(usr);
		return  listUser;
	}
	
	@PostMapping("/user")
	int createUser(@RequestBody User user) {
		Optional<User>opt=Optional.ofNullable(user);
		if(!opt.isEmpty() && opt.isPresent()) {
		System.out.println(user.getName());
		System.out.println(user.getDob());
		System.out.println(user.getAddress().getCity());
		}
		return 1;
	}
	

}
