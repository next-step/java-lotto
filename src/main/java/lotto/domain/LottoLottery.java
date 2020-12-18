package lotto.domain;

import java.util.Collections;
import java.util.List;

import lotto.utils.ValidationUtils;

public class LottoLottery {
	private static final int LOTTO_PRICE_PER_PIECE = 1000;
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final Price price = new Price(LOTTO_PRICE_PER_PIECE);
	private final List<LottoNumber> lottoNumbers;

	public LottoLottery(List<LottoNumber> lottoNumbers) {
		ValidationUtils.validateEmpty(lottoNumbers);
		validateLottoNumberCount(lottoNumbers);
		lottoNumbers.sort(LottoNumber::compare);
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	private void validateLottoNumberCount(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
			throw new IllegalArgumentException(Message.INVALID_LOTTO_NUMBER_COUNT);
		}
	}

	public static Price getPrice() {
		return price;
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}
}
