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

	public boolean isEqualMatchCount(LottoLottery lottoLottery, int matchCount) {
		return matchCount == countMatchNumbers(lottoLottery);
	}

	private long countMatchNumbers(LottoLottery lottoLottery) {
		return lottoNumbers.stream()
			.filter(lottoLottery::contains)
			.count();
	}

	public boolean isMatchBonusBallNumber(LottoLottery lottoLottery) {
		return lottoLottery.contains(bonusBallNumber);
	}
}
