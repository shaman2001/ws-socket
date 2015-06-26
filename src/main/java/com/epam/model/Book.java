package com.epam.model;

public class Book {

	private int idBook;
	private String nameBook;

	public Book(int idBook, String nameBook) {
		this.idBook = idBook;
		this.nameBook = nameBook;
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
