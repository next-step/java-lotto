package lottoautomatic.domain;

public class LottoNumberException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "로또 번호는 1~45 까지만 가능합니다.";

	public LottoNumberException() {
		super(DEFAULT_MESSAGE);
	}

}
