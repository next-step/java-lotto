package lotto.exception;

public class NumberCountException extends RuntimeException {
	private static final String EXCEPTION_MESSAGE = "번호는 6개여야 합니다.";

	public NumberCountException() {
		super(EXCEPTION_MESSAGE);
	}
}
