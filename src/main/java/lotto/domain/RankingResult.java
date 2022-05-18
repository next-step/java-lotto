package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RankingResult {
	private final Map<LottoRank, Long> ranking = new LinkedHashMap<>();
	private RankingResult() {
		Stream.of(LottoRank.values())
			.forEach(rank -> ranking.put(rank, 0L));
	}

	public RankingResult(List<LottoRank> rankResults) {
		this();
		rankResults.forEach(this::countLottoRank);
	}

	public Roi calculateRoi() {
		long proceeds = calculateProceeds();
		long investment = calculateInvestment();

		return new Roi(1 - (double) (investment - proceeds) / (double) investment);
	}

	public Map<LottoRank, Long> ranking() {
		return ranking;
	}

	private long calculateProceeds() {
		return ranking.keySet().stream()
			.filter(rank -> ranking.get(rank) != 0)
			.mapToLong(rank -> rank.amount() * ranking.get(rank))
			.sum();
	}

	private long calculateInvestment() {
		long resultSize = ranking.keySet().stream()
			.mapToLong(ranking::get)
			.sum();

		return Lotto.LOTTO_PRICE.multi(resultSize);
	}

	private void countLottoRank(LottoRank resultRank) {
		if (ranking.containsKey(resultRank)) {
			ranking.put(resultRank, ranking.get(resultRank) + 1);
		}
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("RankingResult{");
		sb.append("ranking=").append(ranking);
		sb.append('}');
		return sb.toString();
	}
}
