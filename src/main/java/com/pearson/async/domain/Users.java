package com.pearson.async.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {
	private final List<User> users;

	@JsonCreator
	public Users(@JsonProperty("users") List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}
}
