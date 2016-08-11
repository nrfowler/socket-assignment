package com.cooksys.socket.assignment;

import com.cooksys.socket.assignment.model.Config;
import com.cooksys.socket.assignment.model.Student;

import java.io.File;

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
        // TODO
    }
}
