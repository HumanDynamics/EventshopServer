package com.eventshop.server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	public static void log(String message) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("/home/pat/EventshopServer/output.txt"), true);
		out.write(message);
		out.close();
	}
}
