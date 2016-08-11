package com.cooksys.socket.assignment;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.cooksys.socket.assignment.model.Config;
import com.cooksys.socket.assignment.model.Student;

public class Client implements Runnable {

	public static void main(String[] args) {
		Socket s;
		Config config = new Config();
		try {
			config = Utils.loadConfig("config/config.xml", Utils.createJAXBContext());
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			System.out.println(config.getRemote().getPort() + " " + config.getRemote().getHost());
			s = new Socket(config.getRemote().getHost(), config.getRemote().getPort());
			InputStream in = s.getInputStream();
			JAXBContext jaxb = Utils.createJAXBContext();
			Unmarshaller unmarshaller = jaxb.createUnmarshaller();
			Student student = new Student();
			student = (Student) unmarshaller.unmarshal(in);
			System.out.println("First Name: " + student.getFirstName());
			System.out.println("Last Name: " + student.getLastName());
			System.out.println("Favorite Language: " + student.getFavoriteLanguage());
			System.out.println("Favorite IDE: " + student.getFavoriteIDE());
			System.out.println("Favorite Paradigm: " + student.getFavoriteParadigm());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}

	@Override
	public void run() {
		Socket s;
		Config config = new Config();
		try {
			config = Utils.loadConfig("config/config.xml", Utils.createJAXBContext());
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			System.out.println(config.getRemote().getPort() + " " + config.getRemote().getHost());
			s = new Socket(config.getRemote().getHost(), config.getRemote().getPort());
			InputStream in = s.getInputStream();
			JAXBContext jaxb = Utils.createJAXBContext();
			Unmarshaller unmarshaller = jaxb.createUnmarshaller();
			Student student = new Student();
			student = (Student) unmarshaller.unmarshal(in);
			System.out.println("First Name: " + student.getFirstName());
			System.out.println("Last Name: " + student.getLastName());
			System.out.println("Favorite Language: " + student.getFavoriteLanguage());
			System.out.println("Favorite IDE: " + student.getFavoriteIDE());
			System.out.println("Favorite Paradigm: " + student.getFavoriteParadigm());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}
