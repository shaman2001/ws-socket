package com.epam.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Server {

	private ExecutorService pool;
	private int port;
	private int sizeOfTreadPool;

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

	public abstract void service(BufferedReader rq, PrintWriter rp) throws IOException;

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
				service(rq, rp);
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
