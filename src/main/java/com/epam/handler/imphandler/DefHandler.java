package com.epam.handler.imphandler;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.epam.handler.IHandle;

public class DefHandler implements IHandle {

	public void handle(BufferedReader rq, PrintWriter rp) {

		String bodyResponse = "<html><body><h1>This res is absent</h1></body></html>";
		rp.println(bodyResponse);

	}

}
