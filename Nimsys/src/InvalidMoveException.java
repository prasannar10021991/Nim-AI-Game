
public class InvalidMoveException extends Exception {
	
	/* 
	Class Name: InvalidMoveException

	Purpose of Class:  InvalidMoveException is an Exception class which returns a message when the exception is thrown which happens
	when the user plays a wrong move during the gameplay execution.

	Authorship Details :
	Name : Prasanna Kumar Ravi
	Student ID : 667913
	Created on : 01-05-2014
	*/
	private static final long serialVersionUID = 1L;

	public InvalidMoveException(int count) {
		super("Invalid move. You must remove between 1 and "+count+" stones.");
	}
	
	public InvalidMoveException() {
		super("Invalid move.");
	}
}
