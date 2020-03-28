package lotto.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

	private final Map<LottoRank, Long> winningMap;
	private final long spentMoney;

	LottoResult(Map<LottoRank, Long> winningMap, long spentMoney) {
		this.winningMap = Collections.unmodifiableMap(makeZeroPaddingEnumMap(winningMap));
		this.spentMoney = spentMoney;
	}

	private Map<LottoRank, Long> makeZeroPaddingEnumMap(Map<LottoRank, Long> winningMap) {
		Map<LottoRank, Long> rankMap = Arrays.stream(LottoRank.values())
				.collect(Collectors.toMap(Function.identity(), rank -> 0L, Long::sum, LinkedHashMap::new));
		winningMap.forEach(rankMap::replace);
		return rankMap;
	}

	public Map<LottoRank, Long> getWinningMap() {
		return winningMap;
	}

	public double getYield() {
		return winningMap
				.entrySet()
				.stream()
				.mapToLong(entry -> entry.getKey().getEarningPrize() * entry.getValue())
				.sum() / (double) spentMoney;
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
