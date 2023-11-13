package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
	private final static int NUMBER_COUNT = 6;

	private final Lotto lottoWinningNumbers;

	public LottoWinningNumbers(Lotto lottoWinningNumbers) {
		this.lottoWinningNumbers = lottoWinningNumbers;
	}

	public boolean isSame(Lotto lotto) {
		return this.lottoWinningNumbers.equals(lotto);
	}

	public int matchedCount(Lotto lotto) {
		List<Integer> lottoWinningList = new ArrayList<>(lottoWinningNumbers.lottoNumbers());
		List<Integer> lottoList = new ArrayList<>(lotto.lottoNumbers());
		lottoWinningList.retainAll(lottoList);

		return lottoWinningList.size();
	}
}
