package lotto.domain.result;

import java.util.List;

public class MatchCountList {
	List<MatchCount> matchCounts;

	public MatchCountList(List<MatchCount> matchCounts) {
		this.matchCounts = matchCounts;
	}

	public List<MatchCount> getMatchCounts() {
		return matchCounts;
	}

	public int getMatchCountSize() {
		return matchCounts.size();
	}
}
