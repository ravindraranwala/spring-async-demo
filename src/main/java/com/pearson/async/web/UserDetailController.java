package com.pearson.async.web;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.async.domain.Users;
import com.pearson.async.service.UserDetailService;

@RestController
public class UserDetailController {
	private final UserDetailService userDetailService;

	public UserDetailController(UserDetailService userDetailService) {
		super();
		this.userDetailService = userDetailService;
	}

	@GetMapping("/users")
	public CompletableFuture<Users> findAllUsers() {
		return userDetailService.findUserDetails();
	}
}
