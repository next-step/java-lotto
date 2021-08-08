package lottomanual.domain;

public class MoneySizeException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "로또 구입을 위해 1,000원 이상 필요합니다.";

	public MoneySizeException() {
		super(DEFAULT_MESSAGE);
	}

}
