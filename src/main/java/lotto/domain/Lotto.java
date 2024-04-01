package lotto.domain;

import lotto.domain.strategy.LottoNumberStrategy;

import java.util.List;

public class Lotto {
	private final LottoNumbers lottoNumbers;

	public Lotto(LottoNumberStrategy strategy) {
		this.lottoNumbers = new LottoNumbers(strategy.generateLottoNumber());
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers.getLottoNumbers();
	}

	public boolean isMatched(int number) {
		return lottoNumbers.isMatched(number);
	}
}
