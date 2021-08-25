package lotto.domain;

import lotto.domain.type.WinningType;

public class LotteryResult {
	private final WinningType winningType;

	public LotteryResult(WinningType winningType) {
		this.winningType = winningType;
	}

	public WinningType getWinningType() {
		return winningType;
	}
}
