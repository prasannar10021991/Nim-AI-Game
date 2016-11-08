
public class InvalidDataException extends Exception{

	/* 
	Class Name: InvalidDataException

	Purpose of Class:  InvalidDataException is an Exception class which returns a message when the exception is thrown which happens
	when the user inputs a wrong command during the execution

	Authorship Details :
	Name : Prasanna Kumar Ravi
	Student ID : 667913
	Created on : 01-05-2014
	*/
	private static final long serialVersionUID = 1L;

	public InvalidDataException() {
		super("Invalid Command.");
	}
	
	public InvalidDataException(String message) {
		super("'"+message+"'"+" is not a valid command.");
	}
}
