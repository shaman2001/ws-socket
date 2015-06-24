package com.epam.runner;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.epam.Server;
import com.epam.constants.CommonConstants;
import com.epam.utils.HttpMethodUtils;


public class Main {

	static String responseBody = "<html><body><h1>Web Server</h1></body></html>";
	static String responseHeader = "HTTP/1.1 200 OK\r\n" + "Server: Server/2051-06-20\r\n" + "Content-Type: text/html\r\n" + "Content-Length: " + responseBody.length() + "\r\n"
			+ "Connection: close\r\n\r\n";
	static String result = responseHeader + responseBody;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Server webServer = new Server(8080, 20) {
			public void service(BufferedReader rq, PrintWriter rp) throws IOException {
		
					List <String>  aa = HttpMethodUtils.getHeaderValue(rq);
					
		

			}

		};
		webServer.start();
	}
}
