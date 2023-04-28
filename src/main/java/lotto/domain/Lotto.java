package lotto.domain;

import java.util.List;

public class Lotto {

	public static final int SIZE = 6;
	public static final int PRICE = 1000;
	public static final int MINIMUM_BOUND = 1;
	public static final int MAXIMUM_BOUND = 45;

	private final LottoNumbers lottoNumbers;
	private final Score score;

	public Lotto() {
		this(0);
	}

	public Lotto(int score) {
		this.lottoNumbers = new LottoNumbers();
		this.score = new Score(score);
	}

	public Lotto(List<Integer> lottoNumbers) {
		this.lottoNumbers = new LottoNumbers(lottoNumbers);
		this.score = new Score(0);
	}

	public Score calculateScore(List<Integer> winNumbers) {
		for (Integer winNumber : winNumbers) {
			this.plusScore(winNumber);
		}
		return this.score;
	}

	public Score getScore() {
		return this.score;
	}

	private void plusScore(Integer winNumber) {
		if (lottoNumbers.contains(winNumber)) {
			this.score.plus();
		}
	}

	public LottoNumbers getLottoNumbers() {
		return this.lottoNumbers;
	}
}
