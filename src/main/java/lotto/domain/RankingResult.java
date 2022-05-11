package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RankingResult {
	private final Map<LottoRank, Long> ranking;

	public RankingResult() {
		ranking = new LinkedHashMap<>();
		Stream.of(LottoRank.values())
			.filter(LottoRank::isStatistics)
			.forEach(rank -> ranking.put(rank, 0L));
	}

	public RankingResult(List<LottoRank> results) {
		this();
		for (LottoRank resultRank : results) {
			countLottoRank(resultRank);
		}
	}

	private void countLottoRank(LottoRank resultRank) {
		if (ranking.containsKey(resultRank)) {
			ranking.put(resultRank, ranking.get(resultRank) + 1);
		}
	}

	@Override
	public String toString() {
		return ranking.keySet().stream()
			.map(rank -> rank.toString() + " - " + ranking.get(rank) + "개")
			.collect(Collectors.joining("\n"));
	}
}
