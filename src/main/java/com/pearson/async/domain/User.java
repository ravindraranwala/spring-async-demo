package com.pearson.async.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	private final String name;
	private final String blog;

	@JsonCreator
	public User(@JsonProperty("name") String name, @JsonProperty("blog") String blog) {
		super();
		this.name = name;
		this.blog = blog;
	}

	public String getName() {
		return name;
	}

	public String getBlog() {
		return blog;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", blog=" + blog + "]";
	}
}
