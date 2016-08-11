package com.cooksys.socket.assignment;

public class Main {
public static void main(String[] args) {
	Thread client = new Thread(new Client());
	Thread server  = new Thread(new Server());
	server.start();
	client.start();
}
}
