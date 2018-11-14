package com.pearson.async.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserId {
	private final List<Integer> ids;

	@JsonCreator
	public GetUserId(@JsonProperty("ids") List<Integer> ids) {
		super();
		this.ids = ids;
	}

	public List<Integer> getIds() {
		return ids;
	}
}
