package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.enums.Ranks;
import lotto.numbers.Lotto;
import lotto.numbers.LottoBundle;

public class LottoWinningStats {
    public static final int PRICE = 1000;

    private final List<Integer> winningStats;
    private final Map<Ranks, Integer> rankingMap;

    public LottoWinningStats(LottoBundle lottoBundle, List<Integer> winningNumbers) {
        this.winningStats = new ArrayList<>(lottoBundle.getBundleSize());
        this.rankingMap = new LinkedHashMap<>();

        calculateWinningStats(lottoBundle, winningNumbers);
    }

    private void calculateWinningStats(LottoBundle lottoBundle, List<Integer> winningNumbers) {
        for (int i=0 ; i<lottoBundle.getBundleSize() ; i++) {
            Lotto lotto = lottoBundle.getLottoByIndex(i);
            winningStats.add(i, lotto.countSameNumbers(winningNumbers));
        }
    }

    public Map<Ranks, Integer> getRanks() {
        if (rankingMap.isEmpty()) {
            return calculateRanks();
        }
        return this.rankingMap;
    }

    public double getYield(int purchaseAmount) {
        Map<Ranks, Integer> rankingMap = getRanks();
        int totalWinningAmounts = rankingMap.entrySet().stream()
                                            .mapToInt(entry -> entry.getKey().getRewards().intValue() * entry.getValue()).sum();

        if (rankingMap.isEmpty() || totalWinningAmounts == 0) {
            return 0;
        }
        return (double) totalWinningAmounts / purchaseAmount;
    }

    private Map<Ranks, Integer> calculateRanks() {
        for (int targetCount : this.winningStats) {
            countByCase(targetCount, rankingMap);
        }
        return rankingMap;
    }

    private void countByCase(int targetCount, Map<Ranks, Integer> rankingMap) {
        Arrays.stream(Ranks.values()).forEach(rank -> {
            checkRankingMap(rank, targetCount, rankingMap);
        });
    }

    private void checkRankingMap(Ranks rank, int targetCount, Map<Ranks, Integer> rankingMap) {
        if (rank.getCountsOfSameNumbers() == targetCount) {
            rankingMap.put(rank, rankingMap.getOrDefault(rank, 0) + 1);
        }
    }
}
