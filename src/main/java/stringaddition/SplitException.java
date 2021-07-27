package stringaddition;

public class SplitException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "음수를 포함한 문자열은 계산할 수 없습니다.";

	public SplitException() {
		super(DEFAULT_MESSAGE);
	}

}
