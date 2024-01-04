package lotto.domain;

public final class LottoNumber {
	private static final Integer MIN_LOTTO_NUMBER = 1;
	private static final Integer MAX_LOTTO_NUMBER = 45;
	private final Integer lottoNumber;

	public LottoNumber(final Integer lottoNumber) {
		validate(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	private void validate(final Integer lotto) {
		if (lotto >= MIN_LOTTO_NUMBER && lotto <= MAX_LOTTO_NUMBER) {
			return;
		}

		throw new IllegalArgumentException("1과 45 사이의 숫자를 입력해주세요.");
	}
}
