package com.epam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.constants.CommonConstants;
import com.epam.handler.Handler;
import com.epam.handler.IHandle;
import com.epam.handler.imphandler.DefHandler;
import com.epam.utils.HttpMethodUtils;
import com.epam.utils.MatcherUtils;
import com.epam.utils.SplitUtils;

public class Server {

	private final List<Handler> handlers = new ArrayList<Handler>();
	private ExecutorService pool;
	private int port;
	private int sizeOfTreadPool;

	public Server() {
	}

	public Server(int port, int sizeOfThreadPool) {
		this.port = port;
		this.sizeOfTreadPool = sizeOfThreadPool;
	}

	@SuppressWarnings("resource")
	public void start() throws IOException {

		pool = Executors.newFixedThreadPool(sizeOfTreadPool);
		ServerSocket serSocket = new ServerSocket(port);
		while (true) {
			Socket sock = serSocket.accept();
			pool.submit(new SocketProcessor(sock));
		}
	}

	public void stop() {
		pool.shutdown();
	}

	public Handler findHendler(BufferedReader rq) throws IOException {
		Handler defHandler = new Handler(null, null, new DefHandler());
		List<String> rqHeaderValue = HttpMethodUtils.getHeaderValue(rq);
		String actualMetnodAndUri = rqHeaderValue.get(0);
		String methodFromRequest = SplitUtils.getCertainSplitValueBy(actualMetnodAndUri, CommonConstants.METHOD, CommonConstants.SPACE);
		String uri = SplitUtils.getCertainSplitValueBy(actualMetnodAndUri, CommonConstants.URI, CommonConstants.SPACE);

		for (Handler handler : handlers) {
			if (methodFromRequest.equals(handler.getMethod()) && MatcherUtils.isMatches(handler.getUri(), uri)) {
				return handler;
			}
		}
		return defHandler;
	}

	public void addHendler(String method, String uri, IHandle handler) {
		handlers.add(new Handler(method, uri, handler));
	}

	private class SocketProcessor implements Runnable {

		private BufferedReader rq;
		private PrintWriter rp;
		private Socket socket;

		public SocketProcessor(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				rq = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				rp = new PrintWriter(socket.getOutputStream(), true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {

				Handler handlerForInvoke = findHendler(rq);
				handlerForInvoke.getiHandle().handle(rq, rp);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
