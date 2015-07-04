package com.epam.handler.imphandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.epam.Store;
import com.epam.handler.IHandle;
import com.epam.model.json.Book;

public class GetAllBooks implements IHandle {

	public void handle(BufferedReader rq, PrintWriter rp) throws IOException {

		String bodyResponse = "";
		List<Book> books = Store.getAllBook();
		for (Book certainBook : books) {
			bodyResponse += "<tr><td>" + certainBook.getIdBook() + "</td><td>" + certainBook.getNameBook() + "</td></tr>";
		}
		rp.println("<html><body> <table border=\"1\"><th>id</th><th>name</th>" + bodyResponse + "</table></body></html>");
	}

}
