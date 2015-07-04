package com.epam.model.json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

	@JsonProperty("id")
	private int idBook;

	@JsonProperty("language")
	private String nameBook;

	@JsonProperty("edition")
	private String edition;

	@JsonProperty("author")
	private String author;

	@JsonProperty("create_date")
	private String date;

	public Book() {
	}

	public Book(int idBook, String nameBook, String edition, String author, String date) {
		this.idBook = idBook;
		this.nameBook = nameBook;
		this.edition = edition;
		this.author = author;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public Book(int idBook) {
		this.idBook = idBook;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

}
