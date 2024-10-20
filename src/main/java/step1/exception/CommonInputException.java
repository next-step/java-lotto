package step1.exception;

public class CommonInputException extends RuntimeException {
	private static final String message = "\n입력 예시는 다음과 같습니다. ex ) 1 + 2 * 3 / 4 - 5 % 6";

	public CommonInputException(String message) {
		super(message + CommonInputException.message);
	}
}
