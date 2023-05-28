package statecensusanalyser;

public class StateCensusException extends Exception {

	public enum ExceptionType {
		Census_File_Invalid, Incorrect_Type, Incorrect_Delimiter, Incorrect_header;
	}

	private static final long serialVersionUID = 1L;
	
	public ExceptionType type;

	
	  public StateCensusException(String message, ExceptionType type) {
	        super(message);
	        this.type = type;
	    }

	    public StateCensusException(String message, ExceptionType type, Throwable cause) {
	        super(message, cause);
	        this.type = type;
	    }

}
