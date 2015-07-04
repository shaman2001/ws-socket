package com.epam.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Book", propOrder = { "id", "language", "edition", "author", "date" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

	@XmlElement(required = true)
	@JsonProperty("id")
	private int id;

	@XmlElement(required = true)
	@JsonProperty("language")
	private String language;

	@XmlElement(required = true)
	@JsonProperty("edition")
	private String edition;

	@XmlElement(required = true)
	@JsonProperty("author")
	private String author;

	@XmlElement(required = true, name = "create_date")
	@JsonProperty("create_date")
	private String date;

	public Book() {
	}

	public Book(int idBook, String language, String edition, String author, String date) {
		this.id = idBook;
		this.language = language;
		this.edition = edition;
		this.author = author;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
