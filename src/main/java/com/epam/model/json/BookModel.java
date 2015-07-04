package com.epam.model.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookModel {

	@JsonProperty("books")
	private List<Book> books;

	@JsonProperty("book")
	private Book book;

}
