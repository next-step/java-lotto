package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class LottoReport {

    public static final double PERCENTAGE = 100.0;

    private final Map<Rank, Integer> countOfMatchByRank = new EnumMap<>(Rank.class);
    private double profitRate;

    public LottoReport(final WinningLotto winners, final Lottos lottos) {
        lottos.forEach(lotto -> updateMatchCountMetrics(winners, lotto));
        updateYield(lottos.size());
    }

    private void updateMatchCountMetrics(WinningLotto winners, Lotto lotto) {
        int countOfMatch = lotto.matchCountWith(winners);
        boolean matchBonus = lotto.matchBonus(winners.bonusNumber);
        Rank.valueOf(countOfMatch, matchBonus)
                .ifPresent(this::updateCountOfMatchByRank);
    }

    private void updateCountOfMatchByRank(Rank rank) {
        countOfMatchByRank.compute(rank, (key, value) -> Optional.ofNullable(value)
                .orElseGet(() -> 0) + 1);
    }

    private void updateYield(int lottoSize) {
        double purchasedAmount = lottoSize * Lotto.PRICE;
        long winningMoney = updateWinnings();
        profitRate = Math.floor((winningMoney / purchasedAmount) * PERCENTAGE) / PERCENTAGE;
    }

    private long updateWinnings() {
        return countOfMatchByRank.keySet()
                .stream()
                .map(rank -> (long) rank.winningMoney * countOfMatchByRank.get(rank))
                .reduce(0L, Long::sum);
    }

    public int countWinnings(Rank rank) {
        return countOfMatchByRank.getOrDefault(rank, 0);
    }

    public double profitRate() {
        return profitRate;
    }

}
