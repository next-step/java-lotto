package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinLottoNumbers {
	private final List<LottoNumber> lottoNumbers;

	public WinLottoNumbers(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
	}

	public List<LottoNumber> getWinNumbers() {
		return lottoNumbers;
	}
}
