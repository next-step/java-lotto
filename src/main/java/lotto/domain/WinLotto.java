package lotto.domain;

public class WinLotto {
	private final Lotto winLotto;
	private final LottoNumber bonus;

	public WinLotto(Lotto winLotto, LottoNumber bonus) {
		this.winLotto = winLotto;
		this.bonus = bonus;
	}

	public Lotto getWinLotto() {
		return winLotto;
	}

	public LottoNumber getBonus() {
		return bonus;
	}
}
