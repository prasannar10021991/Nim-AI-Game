
public class InvalidInputException extends Exception{
	/* 
	Class Name: InvalidInptException

	Purpose of Class:  InvalidInputException is an Exception class which returns a message when the exception is thrown which happens
	when the user inputs a wrong number that is less no of arguments than it is required during the execution

	Authorship Details :
	Name : Prasanna Kumar Ravi
	Student ID : 667913
	Created on : 01-05-2014
	*/
	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
		super("Incorrect number of arguments supplied to command.");
	}
	
	public InvalidInputException(String message) {
		super(message);
	}

}
