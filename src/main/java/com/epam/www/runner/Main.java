package com.epam.www.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.epam.www.Server;
import com.epam.www.constants.CommonConstants;
import com.epam.www.utils.HttpMethodUtils;

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
				if (rq.readLine().contains(CommonConstants.POST)) {

					System.out.println("It is post request");

					int contentLengh = HttpMethodUtils.getContentLength(rq);
					String bodyRequest = HttpMethodUtils.getPostBody(rq);

					System.out.println("Content lenght: " + contentLengh);
					System.out.println("Body request: " + bodyRequest);
				} else {
					System.out.println("It is get request");
				}

				rp.println(result);
			}
		};
		webServer.start();
	}
}
