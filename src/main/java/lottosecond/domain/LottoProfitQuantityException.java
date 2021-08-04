package lottosecond.domain;

public class LottoProfitQuantityException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "당첨번호 일치 수가 올바르지 않습니다.";

	public LottoProfitQuantityException() {
		super(DEFAULT_MESSAGE);
	}

	public LottoProfitQuantityException(String s) {
		super(s);
	}

}
