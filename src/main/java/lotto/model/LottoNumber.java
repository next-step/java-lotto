package lotto.model;

import java.util.List;

public class LottoNumber {
	private final List<Integer> lottoNumbers;

	public LottoNumber(List<Integer> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}
}
