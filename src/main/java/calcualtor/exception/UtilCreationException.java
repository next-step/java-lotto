package calcualtor.exception;

public class UtilCreationException extends RuntimeException {
	private static final long serialVersionUID = -3348274927845078394L;

	public UtilCreationException() {
		super("Utility classes cannot be instantiated.");
	}
}
