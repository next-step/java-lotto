package step1.exception;

public class UserInputEmptyException extends CommonInputException {
	private static final String message = "입력에 빈 값을 입력하셨습니다. 올바른 수식을 입력해주세요.";

	public UserInputEmptyException() {
		super(message);
	}
}
