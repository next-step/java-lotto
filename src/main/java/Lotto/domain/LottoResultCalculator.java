package Lotto.domain;

import java.util.*;

public class LottoResultCalculator {

    private final List<Lotto> lottos;
    private final Set<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;


    public LottoResultCalculator(List<Lotto> lottos, Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> calculateStats() {
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

    public int calculateTotalPrize() {
        Map<Rank, Integer> stats = calculateStats();

        return stats.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }
}
