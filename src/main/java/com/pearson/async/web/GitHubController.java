package com.pearson.async.web;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.async.domain.User;
import com.pearson.async.service.GitHubLookupService;

@RestController
public class GitHubController {
	private final GitHubLookupService lookupService;

	public GitHubController(GitHubLookupService lookupService) {
		super();
		this.lookupService = lookupService;
	}

	@GetMapping("/user/{name}")
	public CompletableFuture<User> findUser(@PathVariable(value = "name") String name) {
		return lookupService.getUser(name);
	}
}
