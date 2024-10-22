package step2.exception;

public class NotEnoughMoneyException extends RuntimeException {
	private static final String message = "로또를 구매하기에 돈이 부족합니다. 1000원 이상 입력해주세요.";

	public NotEnoughMoneyException() {
		super(message);
	}
}
