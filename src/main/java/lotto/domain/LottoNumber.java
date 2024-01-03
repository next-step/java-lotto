package lotto.domain;

public final class LottoNumber {
	private static final Integer ONE = 1;
	private static final Integer FORTYFIVE = 45;
	private final Integer lottoNumber;

	public LottoNumber(final Integer lottoNumber) {
		validate(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	private void validate(final Integer lotto) {
		if (lotto >= ONE && lotto <= FORTYFIVE) {
			return;
		}

		throw new IllegalArgumentException("1과 45 사이의 숫자를 입력해주세요.");
	}
}
