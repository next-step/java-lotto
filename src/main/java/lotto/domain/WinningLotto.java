package lotto.domain;

public final class WinningLotto {
	private final Lotto winningLotto;
	private final LottoNumber bonus;

	public WinningLotto(final Lotto winningLotto, final LottoNumber bonus) {
		this.winningLotto = winningLotto;
		this.bonus = bonus;
	}

	public LottoNumber bonus() {
		return this.bonus;
	}

	public Lotto lotto() {
		return this.winningLotto;
	}
}
