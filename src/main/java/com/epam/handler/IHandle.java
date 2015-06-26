package com.epam.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface IHandle {

	public void handle(BufferedReader rq, PrintWriter rp) throws IOException;

}
