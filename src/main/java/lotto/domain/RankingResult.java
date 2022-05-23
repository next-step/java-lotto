package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RankingResult {
	private final Map<LottoRank, Long> ranking;

	public RankingResult(List<LottoRank> rankResults) {
		ranking = rankResults
			.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
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

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("RankingResult{");
		sb.append("ranking=").append(ranking);
		sb.append('}');
		return sb.toString();
	}
}
