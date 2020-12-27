package lotto.domain.result;

public class MatchResultPerLotto {

	private MatchCount matchCount;

	private HasBonusNumber hasBonusNumber;

	public MatchResultPerLotto(MatchCount matchResult, HasBonusNumber hasBonusNumber) {
		this.matchCount = matchResult;
		this.hasBonusNumber = hasBonusNumber;
	}

	public MatchCount getMatchCount() {
		return matchCount;
	}

	public HasBonusNumber isHasBonusNumber() {
		return hasBonusNumber;
	}

}
