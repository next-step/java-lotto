package lotto.domain;

import java.util.List;

public class Lotto {

	public static final int SIZE = 6;
	public static final int PRICE = 1000;

	private final LottoNumbers lottoNumbers;
	private final Score score;
	private final Score bonusScore;

	public Lotto() {
		this(0);
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Lotto(int score) {
		this.lottoNumbers = new LottoNumbers();
		this.score = new Score(score);
		this.bonusScore = new Score(0);
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Lotto(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = new LottoNumbers(lottoNumbers);
		this.score = new Score(0);
		this.bonusScore = new Score(0);
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Lotto(List<LottoNumber> lottoNumbers, int score) {
		this.lottoNumbers = new LottoNumbers(lottoNumbers);
		this.score = new Score(score);
		this.bonusScore = new Score(0);
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

	public Score calculateBonusScore(LottoNumber bonusNumber) {
		if (this.score.lessThan()) {
			this.plusBonusScore(bonusNumber);
			return this.bonusScore;
		}
		return this.bonusScore;
	}

	private void plusBonusScore(LottoNumber bonusNumber) {
		if (this.lottoNumbers.contains(bonusNumber)) {
			this.bonusScore.plus();
		}
	}

	public Score getScore() {
		return this.score;
	}

	public LottoNumbers getLottoNumbers() {
		return this.lottoNumbers;
	}
}
