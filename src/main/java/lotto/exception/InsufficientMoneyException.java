package lotto.exception;

public class InsufficientMoneyException extends RuntimeException {

	private static final String MESSAGE = "해당 금액으로 로또 티켓을 구매할 수 없습니다. (현재: %d)";

	public InsufficientMoneyException(int amount) {
		super(String.format(MESSAGE, amount));
	}
}
