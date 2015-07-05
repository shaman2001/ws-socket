package com.epam.tests;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.post;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class SmokeTest {

	@Test
	public void checkStatusCodeGetAllBook() {
		Response res = get("/book");
		Assert.assertEquals(200, res.getStatusCode());
	}

	@Test
	public void checkStatusCodeCreateBook() {
		Response res = post("/book");
		Assert.assertEquals(201, res.getStatusCode());
	}

}
