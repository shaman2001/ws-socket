package com.epam.runner;

import java.io.IOException;

import com.epam.Server;
import com.epam.constants.CommonConstants;
import com.epam.handler.imphandler.AddBook;
import com.epam.handler.imphandler.GetAllBooks;

public class Main {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

	Server webServer = new Server(8081, 20);
	webServer.addHendler(CommonConstants.GET, "/book", new GetAllBooks());
	webServer.addHendler(CommonConstants.POST, "/book", new AddBook());
	webServer.start();
    }
}
