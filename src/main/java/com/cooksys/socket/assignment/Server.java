package com.cooksys.socket.assignment;

import com.cooksys.socket.assignment.model.Config;
import com.cooksys.socket.assignment.model.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Server extends Utils {

    /**
     * Reads a {@link Student} object from the given file path
     *
     * @param studentFilePath the
     * @param jaxb
     * @return
     */
    public static Student loadStudent(String studentFilePath, JAXBContext jaxb) {
Student  student=new Student();
        
		try {
			Unmarshaller unmarshaller = jaxb.createUnmarshaller();
			student=(Student) unmarshaller.unmarshal(new File("StudentFilePath"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
    }

    public static void main(String[] args) {
    	ServerSocket ss;
    	Config config =new Config();
    	try {
			config = Utils.loadConfig("config/config.xml", Utils.createJAXBContext());
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ss = new ServerSocket(config.getLocal().getPort());
			Socket s = ss.accept(); //blocking call; program will pause until user connects
			InputStream in=s.getInputStream();
			
			Reader base = new InputStreamReader(in); //ISReader converts byte to String
			
			BufferedReader r = new BufferedReader(base);
			System.out.println(r.readLine());
			ss.close();
			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
