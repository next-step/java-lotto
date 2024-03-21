package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
	public static final int LOTTO_PRICE = 1000;

	private final List<Integer> lottoNumbers;

	public LottoNumbers(List<Integer> lottoNumbers) {
		this.lottoNumbers = getSortedNumbers(lottoNumbers);
	}

	private List<Integer> getSortedNumbers(List<Integer> lottoNumbers) {
		List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);
		Collections.sort(sortedNumbers);
		return sortedNumbers;
	}

	public int getCountOfMatchLottoNumber(WinningLottoNumbers winningNumber) {
		return (int) winningNumber.getWinningLottoNumbers().stream()
				.filter(this.lottoNumbers::contains)
				.count();
	}

	public List<Integer> getLottoNumbers() {
		return lottoNumbers;
	}

	@Override
	public String toString() {
		return lottoNumbers.toString();
	}

}
