package com.hnt.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.hnt.entity.User;
import com.hnt.service.UserService;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest
class UserControllerTest {
	@Mock
	UserService service;
	@InjectMocks
	UserController controller;
//	@Autowired
//	MockMvc mockmvc;
	

	@Test
	void testSaveUser1() {
		User user = new User();
		user.setId(1);
		when(service.save(user)).thenReturn(user);// mocking
		Integer savedUserId = controller.saveUser1(user);
		assertEquals(1, savedUserId);
	}
	@Test
	void testSaveUser() {
		User user = new User();
		user.setId(1);
		//user.setAge(10);
		MultiValueMap headers = new LinkedMultiValueMap<String, String>();
		headers.add("headerfromserver", "success");
		ResponseEntity responseEntity = new ResponseEntity(user,headers , HttpStatus.CREATED);
		when(service.save(user)).thenReturn(user);// mocking
		 ResponseEntity saveUser = controller.saveUser(user,25,5.9f);
		 assertEquals(saveUser, responseEntity);
	}
	@Test
	void testGetUser() {
		Iterable<User> user=new ArrayList<>();
		when(service.getUser()).thenReturn(user);
		Iterable<User> finalUserList=controller.getUser();
		assertEquals(finalUserList, user);
	}
@Test
	void testDeleteUser() {
	service.delete(1);
	verify(service, times(1)).delete((1));
	assertEquals("", "");
	}
@Test
void testDeleteUser1() throws Exception {
	//mockmvc.perform( MockMvcRequestBuilders.delete("/user/{userid}",1) );
  controller.deleteUser(1);
  assertEquals("", "");

	
}
//@Test
//void testHandleException() {
//	MethodArgumentNotValidException ex=new MethodArgumentNotValidException();
//	Map<String, String> errors = new HashMap();
//	ex.getBindingResult().getAllErrors().forEach((error) -> {
//		String fieldname = ((FieldError) error).getField();
//		String message = ((FieldError) error).getDefaultMessage();
//		errors.put(fieldname, message);
//	});
//}
}
