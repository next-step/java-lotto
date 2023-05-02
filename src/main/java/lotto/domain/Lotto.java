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

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Lotto(int score) {
		this.lottoNumbers = new LottoNumbers();
		this.score = new Score(score);
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Lotto(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = new LottoNumbers(lottoNumbers);
		this.score = new Score(0);
	}

	public Score calculateScore(WinningNumbers winningNumbers) {
		for (LottoNumber winningNumber : winningNumbers.getWinningNumbers()) {
			this.plusScore(winningNumber);
		}
		return this.score;
	}

	private void plusScore(LottoNumber winningNumber) {
		if (this.lottoNumbers.contains(winningNumber)) {
			this.score.plus();
		}
	}

	public Score calculateScore(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
		for (LottoNumber winningNumber : winningNumbers.getWinningNumbers()) {
			this.plusScore(winningNumber);
		}
		this.plusBonusScore(bonusNumber);
		return this.score;
	}

	private void plusBonusScore(LottoNumber bonusNumber) {
		if (this.lottoNumbers.contains(bonusNumber)) {
			this.score.plusBonus();
		}
	}

	public Rank rank() {
		return Rank.of(this.score.getScore(), this.score.isMatchBonus());
	}

	public LottoNumbers getLottoNumbers() {
		return this.lottoNumbers;
	}
}
