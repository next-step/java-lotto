package lotto.domain;

public class LottoMatchResult {
	private int matchResult;
	private boolean hasBonusNumber;

	public LottoMatchResult(int matchResult, boolean hasBonusNumber) {
		this.matchResult = matchResult;
		this.hasBonusNumber = hasBonusNumber;
	}

	public int getMatchResult() {
		return matchResult;
	}

	public boolean isHasBonusNumber() {
		return hasBonusNumber;
	}
}
