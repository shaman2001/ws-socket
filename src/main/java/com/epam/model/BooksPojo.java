package com.epam.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksPojo {

	@XmlElement(name = "book")
	@XmlElementWrapper(name = "books")
	@JsonProperty("books")
	private List<Book> book;

	public List<Book> getBook() {
		return book;
	}

	public void setBooks(List<Book> book) {
		this.book = book;
	}
}
