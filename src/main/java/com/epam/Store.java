package com.epam;

import java.util.ArrayList;
import java.util.List;

import com.epam.model.Book;

public class Store {

	public static List<Book> getAllBook() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1, "Java"));
		books.add(new Book(2, "C++"));
		books.add(new Book(3, "C#"));
		books.add(new Book(4, "PHP"));
		books.add(new Book(5, "Java"));
		books.add(new Book(6, "C++"));
		books.add(new Book(7, "C#"));
		books.add(new Book(8, "PHP"));
		books.add(new Book(9, "PHP"));
		return books;
	}

}
