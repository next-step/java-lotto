package nextstep.step2.domain;

public class WinningLotto {
	private Lotto lastWeekLotto;
	private LottoNumber bonusNumber;

	public WinningLotto(Lotto lastWeekLotto, LottoNumber bonusNumber) {
		this.lastWeekLotto = lastWeekLotto;
		this.bonusNumber = bonusNumber;
	}

	public Lotto getLastWeekLotto() {
		return lastWeekLotto;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}
}
