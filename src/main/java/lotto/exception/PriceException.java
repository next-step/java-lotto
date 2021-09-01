package lotto.exception;

public class PriceException extends RuntimeException {
	private static final String EXCEPTION_MESSAGE = "로또를 구매할 수 없는 금액입니다.";
	
	public PriceException() {
		super(EXCEPTION_MESSAGE);
	}
}
