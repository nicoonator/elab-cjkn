/**
 * 
 */
package Exceptions;

/**
 * @author Nico Rychlik
 *
 */
public class PersonNichtInDBException extends DatabaseException {
	
	public PersonNichtInDBException() {
		
	}
	
	@Override
	public String getMessage(){
		return "Die gesuchte Person ist nicht mehr Teil des Datenbestandes!";
	}
	
	@Override
	public String toString(){
		return getMessage();
	}
}
