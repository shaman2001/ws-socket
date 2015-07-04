package com.epam;

import java.util.ArrayList;
import java.util.List;

import com.epam.model.json.Book;

public class Store {

	public static List<Book> getAllBook() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(01, "Java", "third", "Herbert Schildt", "1987-05-12 00:00:00 -0800"));
		return books;
	}

}
