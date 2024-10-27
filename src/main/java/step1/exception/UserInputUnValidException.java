package step1.exception;

public class UserInputUnValidException extends CommonInputException {
	private static final String message = "숫자와 사칙연산 사이는 공백이여야 합니다. 사칙연산은 [+-*/%] 만 허용합니다.";

	public UserInputUnValidException() {
		super(message);
	}
}
