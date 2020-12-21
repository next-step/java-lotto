package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
	private List<LottoNumber> lottoNumbers;

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public LottoNumbers generateLottoNumbers(int lottoGameCount, NumberGenerator numberGenerator) {
		lottoNumbers = new ArrayList<>();
		for (int i = 0; i < lottoGameCount; i++) {
			LottoNumber lottoNumber = new LottoNumber();
			lottoNumber.generate(numberGenerator);
			lottoNumbers.add(lottoNumber);
		}
		return this;
	}
}
