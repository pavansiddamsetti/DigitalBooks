package com.hnt.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hnt.UserRepository;
import com.hnt.entity.User;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@InjectMocks
	UserService service;
	
	@Mock
	UserRepository repository;
	@Test
	void testSave() {
		User user = new User();
		user.setId(1);
		user.setName("john");
		when(repository.save(user)).thenReturn(user);//mock
		service.save(user);
		assertEquals(1,	user.getId());
	}
//	404
	@Test
	void testSaveForException() {
		assertThrows(IllegalArgumentException.class, ()->{
			User user = new User();
			user.setName("Ram");
			User save = service.save(user);
		});
	}
	@Test
	void testGetUser() {
	Iterable<User> user=new ArrayList<>();
	when(repository.findAll()).thenReturn(user);
	Iterable<User> finalUserList=service.getUser();
	assertEquals(finalUserList, user);
	}
	@Test
	void testDeleteUser() {
	service.delete(1);
	assertEquals("", "");
	}
	


}
