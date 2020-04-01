package lotto.dto;

import lotto.domain.LottoRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatisticsDto {

	private final Map<LottoRank, Long> winningMap;
	private final long spentMoney;

	public LottoStatisticsDto(Map<LottoRank, Long> winningMap, long spentMoney) {
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
				.mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
				.sum() / (double) spentMoney;
	}

}
