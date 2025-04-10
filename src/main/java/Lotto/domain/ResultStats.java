package Lotto.domain;

import Lotto.constants.Rank;


import java.util.*;

public class ResultStats {
    private final Map<Rank, Integer> stats = new EnumMap<>(Rank.class);
    private final int totalPrize;

    public ResultStats(List<Lotto> lottos, Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        for (Rank rank : Rank.values()) {
            stats.put(rank, 0);
        }

        this.totalPrize = lottos.stream()
                .map(lotto -> {
                    int matchCount = lotto.countMatches(winningNumbers);
                    boolean matchBonus = lotto.contains(bonusNumber);
                    return Rank.fromMatchCountAndBonus(matchCount, matchBonus);
                })
                .filter(rank -> rank != Rank.MISS)
                .peek(rank -> stats.put(rank, stats.get(rank) + 1))
                .mapToInt(Rank::getWinningMoney)
                .sum();
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public double calculateProfitRate(int totalSpent) {
        return totalPrize / (double) totalSpent;
    }

    public Map<Rank, Integer> getStats() {
        return Collections.unmodifiableMap(stats);
    }
}

