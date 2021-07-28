package stringaddition;

public class NationalNumberException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "음수를 포함한 문자열은 계산할 수 없습니다.";

	public NationalNumberException() {
		super(DEFAULT_MESSAGE);
	}

	public NationalNumberException(String message) {
		super(message);
	}

}
