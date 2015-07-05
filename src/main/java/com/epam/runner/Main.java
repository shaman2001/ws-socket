package com.epam.runner;

import java.io.IOException;

import com.epam.Server;
import com.epam.constants.CommonConstants;
import com.epam.handler.imphandler.AddBook;
import com.epam.handler.imphandler.GetAllBooks;
import com.epam.handler.imphandler.GetCertainBook;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Server webServer = new Server(8080, 20);

		webServer.addHendler(CommonConstants.GET, "/book", new GetAllBooks());
		webServer.addHendler(CommonConstants.POST, "/book", new AddBook());
		webServer.addHendler(CommonConstants.GET, "/book/{id}", new GetCertainBook());
		webServer.start();
	}
}
