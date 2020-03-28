package lotto.domain;

import java.util.*;

public class LottoResult {

	private final Map<LottoRank, Integer> winningMap;

	public LottoResult(Map<LottoRank, Integer> winningMap) {
		this.winningMap = Collections.unmodifiableMap(winningMap);
	}

	public Map<LottoRank, Integer> getWinningMap() {
		return winningMap;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoResult that = (LottoResult) o;
		return Objects.equals(winningMap, that.winningMap);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winningMap);
	}
}
