package com.epam.handler.imphandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.epam.handler.IHandle;

public class GetCertainBook implements IHandle {

	public void handle(BufferedReader rq, PrintWriter rp) throws IOException {
		//
		//
		//
		// String bodyResponse = "";
		// String strMethodAndUri = rq.get(0);
		// String uri = SplitUtils.getCertainSplitValueBy(strMethodAndUri,
		// CommonConstants.URI, CommonConstants.SPACE);
		//
		// int lastIndexForId = uri.lastIndexOf("/");
		// String certainBookId = uri.substring(lastIndexForId);
		// int idFromRequest = Integer.parseInt(certainBookId);
		//
		// List<Book> allBook = Store.getAllBook();
		// for (Book alBook : allBook) {
		// if (alBook.getIdBook() == idFromRequest) {
		// bodyResponse = alBook.getNameBook();
		// break;
		// } else {
		// bodyResponse = "Book is absent";
		// }
		// }
		//
		// rp.println("<html><body> <h3>" + bodyResponse +
		// "</h3></body></html>");
	}

}
