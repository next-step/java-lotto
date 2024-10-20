package step1.exception;

public class DivideZeroException extends RuntimeException {
	private static final String message = "값은 0으로 나눌 수 없습니다.";

	public DivideZeroException() {
		super(message);
	}
}
