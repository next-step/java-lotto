package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {
	private final Lotto lottoWinningNumbers;

	public LottoWinningNumbers(Lotto lotto) {
		checkLottoSizeIsValid(lotto);
		this.lottoWinningNumbers = lotto;
	}

	private void checkLottoSizeIsValid(Lotto lotto) {
		if(lotto == null || lotto.lottoNumbers().isEmpty()) {
			throw new IllegalArgumentException("로또 번호가 존재해야 합니다");
		}
	}

	public boolean isSame(Lotto lotto) {
		return this.lottoWinningNumbers.equals(lotto);
	}

	public int matchesNumber(Lotto lotto) {
		List<LottoNumber> lottoWinningList = new ArrayList<>(lottoWinningNumbers.lottoNumbers());
		List<LottoNumber> lottoList = new ArrayList<>(lotto.lottoNumbers());

		lottoWinningList.retainAll(lottoList);

		return lottoWinningList.size();
	}
}
