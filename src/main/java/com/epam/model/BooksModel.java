package com.epam.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksModel {

	@XmlElement(required = true, name = "book")
	private List<Book> book;

	public List<Book> getBooks() {
		return book;
	}

	public void setBooks(List<Book> books) {
		this.book = books;
	}
}
