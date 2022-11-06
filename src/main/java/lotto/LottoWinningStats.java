package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.enums.Ranks;
import lotto.numbers.Lotto;

public class LottoWinningStats {
    public static final int PRICE = 1000;

    private final List<Integer> winningStats;
    private final Map<Ranks, Integer> rankingMap;

    public LottoWinningStats(Lotto lotto, List<Integer> winningNumbers) {
        this.winningStats = new ArrayList<>(lotto.getNumbersSize());
        this.rankingMap = new LinkedHashMap<>();

        calculateWinningStats(lotto, winningNumbers);
    }

    private void calculateWinningStats(Lotto lotto, List<Integer> winningNumbers) {
        // 로또 객체를 기반으로 당첨 통계 계산
        for (int i=0 ; i<lotto.getNumbersSize() ; i++) {
            winningStats.add(i, getCount(lotto, i, winningNumbers));
        }
    }

    public Map<Ranks, Integer> getRanks() {
        if (rankingMap.isEmpty()) {
            return calculateRanks();
        }
        return this.rankingMap;
    }

    public double getYield(int purchaseCount) {
        Map<Ranks, Integer> rankingMap = getRanks();
        int totalAmounts = purchaseCount * PRICE;
        int totalWinningAmounts = rankingMap.entrySet().stream()
                                            .mapToInt(entry -> entry.getKey().getRewards().intValue() * entry.getValue()).sum();

        if (rankingMap.isEmpty() || totalWinningAmounts == 0) {
            return 0;
        }
        return (double) totalWinningAmounts / totalAmounts;
    }

    private Map<Ranks, Integer> calculateRanks() {
        validateWinningStats();

        for (int targetCount : this.winningStats) {
            countByCase(targetCount, rankingMap);
        }
        return rankingMap;
    }

    private void validateWinningStats(){
        if(this.winningStats.isEmpty()) {
            throw new RuntimeException("winningStats 인스턴스 변수 셋팅이 필요합니다.");
        }
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

    private int getCount(Lotto lotto, int index, List<Integer> winningNumbers) {
        int count = 0;
        for (Integer winningNumber : winningNumbers) {
            count = checkCount(lotto, index, winningNumber, count);
        }
        return count;
    }

    private int checkCount(Lotto lotto, int index, Integer winningNumber, int count) {
        if (lotto.containsNumber(index, winningNumber)) {
            count++;
        }
        return count;
    }
}
