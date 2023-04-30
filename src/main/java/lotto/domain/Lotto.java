package lotto.domain;

import java.util.List;

public class Lotto {

	public static final int SIZE = 6;
	public static final int PRICE = 1000;

	private final LottoNumbers lottoNumbers;
	private final Score score;

	public Lotto() {
		this(0);
	}

	public Lotto(int score) {
		this.lottoNumbers = new LottoNumbers();
		this.score = new Score(score);
	}

	public Lotto(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = new LottoNumbers(lottoNumbers);
		this.score = new Score(0);
	}

	public Score calculateScore(WinNumbers winNumbers) {
		for (LottoNumber winNumber : winNumbers.getWinNumbers()) {
			this.plusScore(winNumber);
		}
		return this.score;
	}

	private void plusScore(LottoNumber winNumber) {
		if (this.lottoNumbers.contains(winNumber)) {
			this.score.plus();
		}
	}

	public Score getScore() {
		return this.score;
	}

	public LottoNumbers getLottoNumbers() {
		return this.lottoNumbers;
	}
}
