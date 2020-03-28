package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

	private final Map<LottoRank, Long> winningMap;
	private final int buyPrize;

	LottoResult(Map<LottoRank, Long> winningMap, int buyPrize) {
		this.winningMap = Collections.unmodifiableMap(winningMap);
		this.buyPrize = buyPrize;
	}

	public Map<LottoRank, Long> getWinningMap() {
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

	public double getYield() {
		return winningMap
				.entrySet()
				.stream()
				.mapToLong(entry -> entry.getKey().getEarningPrize() * entry.getValue())
				.sum() / (double) buyPrize;
	}
}
