package lotto.exception;

public class UtilCreationException extends RuntimeException {
	private static final long serialVersionUID = -2103368678816319074L;

	public UtilCreationException() {
		super("Utility classes cannot be instantiated.");
	}
}
