package lotto.result;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import lotto.LottoKiosk;
import lotto.Lottos;
import lotto.Ranking;
import lotto.WinningBalls;

public class Statistics {

	private static final int RANKING_MAP_DEFAULT_VALUE = 0;
	private static final int RANKING_MAP_INCREASE_VALUE = 1;
	private static final int DECIMAL = 3;

	private final Map<Ranking, Integer> rankingMap;
	private final int lottoPurchaseCount;

	private Statistics(Map<Ranking, Integer> rankingMap, int lottoPurchaseCount) {
		this.rankingMap = rankingMap;
		this.lottoPurchaseCount = lottoPurchaseCount;
	}

	public static Statistics from(Lottos lottosOfUser, WinningBalls winningBalls) {
		Map<Ranking, Integer> rankingMap = lottosOfUser.getRankings(winningBalls)
													   .stream()
													   .collect(groupingBy(Function.identity(),
																		   summingInt(count -> RANKING_MAP_INCREASE_VALUE)));

		return new Statistics(rankingMap, lottosOfUser.getPurchaseLottoCount());
	}

	public Map<Ranking, Integer> getWinningResult() {
		return Stream.of(Ranking.values())
					 .collect(toMap(identity(),
									ranking -> rankingMap.getOrDefault(ranking, RANKING_MAP_DEFAULT_VALUE)));
	}

	public double getEarningsRate() {
		BigDecimal lottoPurchasePrice = new BigDecimal(lottoPurchaseCount * LottoKiosk.LOTTO_PRICE);
		BigDecimal totalPrizeMoney = new BigDecimal(getTotalPrizeMoney());

		return totalPrizeMoney.divide(lottoPurchasePrice, DECIMAL, BigDecimal.ROUND_HALF_UP)
							  .doubleValue();
	}

	private long getTotalPrizeMoney() {
		return rankingMap.keySet()
						 .stream()
						 .mapToLong(ranking -> ranking.getPrizeMoney() * rankingMap.get(ranking))
						 .sum();
	}
}
