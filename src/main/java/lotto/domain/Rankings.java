package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Rankings {

    private static final int REWARD_SCALE = 3;
    private static final int DEFAULT_FREQUENCY = 0;

    private final List<Ranking> rankings;

    private Rankings(List<Ranking> rankings) {
        this.rankings = new ArrayList<>(rankings);
    }

    public static Rankings of(List<Lotto> userNumbers,
        WinningLotto winningLotto) {
        List<Ranking> rankings = new ArrayList<>();
        for (Lotto userNumber : userNumbers) {
            rankings.add(Ranking.of(userNumber, winningLotto));
        }
        return new Rankings(rankings);
    }

    public int countWinnerPriceSum() {
        return rankings.stream()
            .map(Ranking::getWinnerPrice)
            .reduce(0, Integer::sum);
    }

    public int countFrequency(Ranking ranking) {
        Map<Ranking, Integer> rankingCount = new EnumMap<>(Ranking.class);
        for (Ranking rank : rankings) {
            rankingCount.put(rank, rankingCount.getOrDefault(rank, DEFAULT_FREQUENCY) + 1);
        }
        return rankingCount.getOrDefault(ranking, DEFAULT_FREQUENCY);
    }

    public double countRewardRate(int buyPrice) {
        int winnerPriceSum = countWinnerPriceSum();
        return BigDecimal.valueOf(winnerPriceSum)
            .divide(BigDecimal.valueOf(buyPrice), REWARD_SCALE, RoundingMode.HALF_EVEN)
            .doubleValue();
    }
}
