package lotto.domain;

public class WinningLotto {

	public static final String MESSAGE_INVALID_BONUS_NUMBER = "보너스번호는 당첨번호에 포함되어지 않아야 합니다.";
	private final Lotto winningLotto;
	private final LottoNumber bonusNumber;

	public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
		if (winningLotto.contains(bonusNumber)) {
			throw new IllegalArgumentException(MESSAGE_INVALID_BONUS_NUMBER);
		}
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;

	}

	public WinningLotto(Lotto winningLotto, int bonusNumber) {
		this(winningLotto, new LottoNumber(bonusNumber));
	}

	public boolean contains(LottoNumber lottoNumber) {
		return winningLotto.contains(lottoNumber);
	}

	public Rank findRank(Lotto lotto) {
		return Rank.findRank(matchCount(lotto), lotto.contains(bonusNumber));
	}

	private int matchCount(Lotto lotto) {
		return this.winningLotto.matchCount(lotto);
	}

}
