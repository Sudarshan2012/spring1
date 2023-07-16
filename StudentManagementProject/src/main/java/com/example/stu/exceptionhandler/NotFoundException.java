package com.example.stu.exceptionhandler;


//Create aNotfoundException class and extends Exception Class.
public class NotFoundException extends Exception {
	
	public NotFoundException(String message) // create a a Constructor to display the Message
	{
		super(message);
	}

}
