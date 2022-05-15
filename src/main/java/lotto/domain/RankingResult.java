package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RankingResult {
	private final Map<LottoRank, Long> ranking = new LinkedHashMap<>();
	public RankingResult() {
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

	public Yield calculateYield() {
		long proceeds = calculateProceeds();
		long investment = calculateInvestment();

		return new Yield(1 - (double) (investment - proceeds) / (double) investment);
	}

	private long calculateProceeds() {
		return ranking.keySet().stream()
			.filter(rank -> ranking.get(rank) != 0)
			.mapToLong(rank -> rank.amount() * ranking.get(rank))
			.sum();
	}

	private long calculateInvestment() {
		long resultSize = ranking.keySet().stream().mapToLong(ranking::get).sum();

		return Lotto.LOTTO_PRICE.multi(resultSize);
	}

	private void countLottoRank(LottoRank resultRank) {
		if (ranking.containsKey(resultRank)) {
			ranking.put(resultRank, ranking.get(resultRank) + 1);
		}
	}

}
