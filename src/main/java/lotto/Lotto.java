package lotto;

import java.util.List;

public class Lotto {
	private final List<Integer> lottoNumbers;

	public Lotto(LottoNumberStrategy strategy) {
		this.lottoNumbers = strategy.generateLottoNumber();
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}
}
