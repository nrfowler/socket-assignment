package com.cooksys.socket.assignment;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.bind.JAXBException;

import com.cooksys.socket.assignment.Utils;
import com.cooksys.socket.assignment.model.Config;

public class Client {

    public static void main(String[] args) {
    	Socket s;
    	Config config =new Config();
    	try {
			config = Utils.loadConfig("config/config.xml", Utils.createJAXBContext());
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
    		s = new Socket(config.getRemote().getHost(), config.getRemote().getPort());
    		OutputStream os = s.getOutputStream();
    		OutputStreamWriter w = new OutputStreamWriter(os);
    		//BufferedOutputStream bos = new BufferedOutputStream(os);
    		BufferedWriter bw = new BufferedWriter(w);
    		bw.write("Nathan");
    		bw.close();
    	} catch (UnknownHostException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	System.out.println();
    }
}
