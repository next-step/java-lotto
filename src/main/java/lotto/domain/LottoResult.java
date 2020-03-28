package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

	private final Map<LottoRank, Long> winningMap;
	private final long spentMoney;

	LottoResult(Map<LottoRank, Long> winningMap, long spentMoney) {
		this.winningMap = Collections.unmodifiableMap(winningMap);
		this.spentMoney = spentMoney;
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
				.sum() / (double) spentMoney;
	}
}
