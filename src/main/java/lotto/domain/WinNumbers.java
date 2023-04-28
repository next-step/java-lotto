package lotto.domain;

import java.util.List;

public class WinNumbers {

	private final List<Integer> winNumbers;

	public WinNumbers(List<Integer> winNumbers) {
		this.winNumbers = winNumbers;
	}

	public Score plusScore(LottoNumbers lottoNumbers, Score score) {
		for (Integer winNumber : winNumbers) {
			this.plus(lottoNumbers, score, winNumber);
		}
		return score;
	}

	private void plus(LottoNumbers lottoNumbers, Score score, Integer winNumber) {
		if (lottoNumbers.contains(winNumber)) {
			score.plus();
		}
	}
}
