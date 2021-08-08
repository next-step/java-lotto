package lottomanual.domain;

public class LottoNumbersSizeException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "로또 번호는 6개만 가능합니다.";

	public LottoNumbersSizeException() {
		super(DEFAULT_MESSAGE);
	}

}
