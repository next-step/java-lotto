package lotto.domain;

import java.util.Set;

class LottoTicket {

	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final String INVALID_LOTTO_NUMBERS_MESSAGE = "로또 번호가 유효하지 않습니다.";
	private final Set<LottoNumber> lottoNumbers;

	LottoTicket(Set<LottoNumber> lottoNumbers) {
		validate(lottoNumbers);

		this.lottoNumbers = lottoNumbers;
	}

	private void validate(Set<LottoNumber> lottoNumbers) {
		if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_MESSAGE);
		}
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}

}
