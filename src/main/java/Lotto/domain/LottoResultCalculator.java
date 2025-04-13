package Lotto.domain;

import java.util.*;

public class LottoResultCalculator {

    public static Map<Rank, Integer> calculateStats(List<Lotto> lottos, Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        Map<Rank, Integer> stats = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            stats.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winningNumbers);
            boolean matchBonus = lotto.contains(bonusNumber);
            Rank rank = Rank.fromMatchCountAndBonus(matchCount, matchBonus);

            if (rank != Rank.MISS) {
                stats.put(rank, stats.get(rank) + 1);
            }
        }

        return stats;
    }

    public static int calculateTotalPrize(Map<Rank, Integer> stats) {
        return stats.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }
}
