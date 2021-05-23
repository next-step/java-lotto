package lotto.domain;


import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class LottoReport {
    public static final double PERCENTAGE = 100.0;

    Map<Rank, Integer> countOfMatchByRank = new EnumMap<>(Rank.class);
    private double yield;

    public LottoReport(final Lotto winners, final List<Lotto> lottos) {
        lottos.forEach(lotto -> updateMatchCountMetrics(winners, lotto));
        updateYield(lottos.size());
    }

    private void updateMatchCountMetrics(Lotto winners, Lotto lotto) {
            int countOfMatch = lotto.matchCountWith(winners);
            Rank.valueOf(countOfMatch)
                    .ifPresent(this::updateCountOfMatchByRank);
    }

    private void updateCountOfMatchByRank(Rank rank) {
        countOfMatchByRank.computeIfAbsent(rank, key -> 0);
        countOfMatchByRank.compute(rank, (key, value) -> value + 1);
    }

    private void updateYield(int lottoSize) {
        double purchasedAmount = lottoSize * Lotto.PRICE;
        long winningMoney = updateWinnings();
        yield = Math.floor((winningMoney / purchasedAmount) * PERCENTAGE) / PERCENTAGE;
    }

    private long updateWinnings() {
        return countOfMatchByRank.keySet()
                .stream()
                .map(rank -> (long) rank.winningMoney * countOfMatchByRank.get(rank))
                .reduce(0L, (a, b) -> a + b);
    }

    public int countWinnings(Rank rank) {
        return countOfMatchByRank.getOrDefault(rank, 0);
    }

    public double yield() {
        return yield;
    }

}
