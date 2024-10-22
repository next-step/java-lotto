package step2.exception;

public class MoneyOverLimitException extends RuntimeException {
	private static final String message = "한 주에는 최대 10만원까지만 로또를 구입하실 수 있습니다.";

	public MoneyOverLimitException() {
		super(message);
	}
}
