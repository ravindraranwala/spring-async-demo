package com.pearson.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pearson.async.domain.GetUserId;
import com.pearson.async.domain.Users;

@Service
public class UserDetailService {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);
	private final RestTemplate restTemplate;

	public UserDetailService(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}

	public CompletableFuture<Users> findUserDefails() {
		return CompletableFuture.supplyAsync(this::getUserIds).thenApply(this::getUserDetails);
	}

	private List<Integer> getUserIds() {
		logger.info("Looking up for user ID values");
		return restTemplate.getForObject("http://www.mocky.io/v2/5bebd86b3300009f00fbc084", GetUserId.class).getIds();
	}

	private Users getUserDetails(List<Integer> ids) {
		String queryParam = ids.stream().map(id -> "id=" + id).collect(Collectors.joining("&", "?", ""));
		String url = String.format("http://www.mocky.io/v2/5bebd6f03300006c00fbc075/%s", queryParam);
		return restTemplate.getForObject(url, Users.class);
	}
}
