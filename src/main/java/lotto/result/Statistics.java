package lotto.result;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import lotto.LottoKiosk;
import lotto.LottoNumbers;
import lotto.Lottos;
import lotto.Ranking;

public class Statistics {

	private static final int RANKING_MAP_DEFAULT_VALUE = 0;
	private static final int RANKING_MAP_INCREASE_VALUE = 1;
	private static final int DECIMAL = 3;

	private final Map<Ranking, Integer> rankingMap;
	private final int purchaseLottoCount;

	private Statistics(Map<Ranking, Integer> rankingMap, int purchaseLottoCount) {
		this.rankingMap = rankingMap;
		this.purchaseLottoCount = purchaseLottoCount;
	}

	public static Statistics from(Lottos myLottos, LottoNumbers winningNumbers) {
		Map<Ranking, Integer> rankingMap = myLottos.getRankings(winningNumbers)
												   .stream()
												   .collect(groupingBy(Function.identity(),
																	   summingInt(count -> RANKING_MAP_INCREASE_VALUE)));

		return new Statistics(rankingMap, myLottos.getPurchaseLottoCount());
	}

	public Map<Ranking, Integer> getRankingResult() {
		return Stream.of(Ranking.values())
					 .collect(toMap(identity(),
									ranking -> rankingMap.getOrDefault(ranking, RANKING_MAP_DEFAULT_VALUE)));
	}

	public double getEarningsRate() {
		BigDecimal paidForPurchaseLotto = new BigDecimal(purchaseLottoCount * LottoKiosk.LOTTO_PRICE);
		BigDecimal totalPrizeMoney = new BigDecimal(getTotalPrizeMoney());

		return totalPrizeMoney.divide(paidForPurchaseLotto, DECIMAL, BigDecimal.ROUND_HALF_UP)
							  .doubleValue();
	}

	private long getTotalPrizeMoney() {
		return rankingMap.keySet()
						 .stream()
						 .mapToLong(ranking -> ranking.getPrizeMoney() * rankingMap.get(ranking))
						 .sum();
	}
}
