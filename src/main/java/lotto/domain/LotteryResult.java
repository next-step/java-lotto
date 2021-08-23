package lotto.domain;

import lotto.domain.type.WinningType;

public class LotteryResult {
	private Lotto lotto;
	private WinningType winningType;

	public LotteryResult(Lotto lotto, WinningType winningType) {
		this.lotto = lotto;
		this.winningType = winningType;
	}

	public WinningType getWinningType() {
		return winningType;
	}
}
