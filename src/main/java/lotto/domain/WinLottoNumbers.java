package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinLottoNumbers {
	private final List<LottoNumber> lottoNumbers;
	private final LottoNumber bonusBallNumber;

	public WinLottoNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusBallNumber) {
		this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
		this.bonusBallNumber = bonusBallNumber;
	}

	public List<LottoNumber> getWinNumbers() {
		return lottoNumbers;
	}

	public LottoNumber getBonusBallNumber() {
		return bonusBallNumber;
	}
}
