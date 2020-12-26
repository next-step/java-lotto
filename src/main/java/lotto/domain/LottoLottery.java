package lotto.domain;

import java.util.Collections;
import java.util.List;

import lotto.utils.ValidationUtils;

public class LottoLottery {
	public static final int LOTTO_PRICE_PER_PIECE = 1000;
	public static final int LOTTO_NUMBER_COUNT = 6;
	private final List<LottoNumber> lottoNumbers;

	public LottoLottery(List<LottoNumber> lottoNumbers) {
		ValidationUtils.validateEmpty(lottoNumbers);
		validateLottoNumberCount(lottoNumbers);
		lottoNumbers.sort(LottoNumber::compare);
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	private void validateLottoNumberCount(List<LottoNumber> lottoNumbers) {
		long count = lottoNumbers.stream()
			.distinct()
			.count();

		if (count != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(Message.INVALID_LOTTO_NUMBER_COUNT);
		}
	}

	public LottoRank checkLottoRank(WinLottoNumbers winLottoNumbers) {
		return LottoRank.findMatchRank(this, winLottoNumbers);
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}


	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}
}
