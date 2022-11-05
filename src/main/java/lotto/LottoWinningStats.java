package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.enums.Rank;
import lotto.numbers.Lotto;

public class LottoWinningStats {
    private final List<Integer> winningStats;
    private final Map<Rank, Integer> rankingMap;

    public LottoWinningStats(Lotto lotto) {
        this.winningStats = new ArrayList<>(lotto.getNumbersSize());
        this.rankingMap = new LinkedHashMap<>();
    }

    public void calculateWinningStats(Lotto lotto, List<Integer> winningNumbers, int totalCount) {
        // 로또 객체를 기반으로 당첨 통계 계산
        for (int i=0 ; i<totalCount ; i++) {
            winningStats.add(i, getCount(lotto, i, winningNumbers));
        }
    }

    public Map<Rank, Integer> getRanks() {
        if (rankingMap.isEmpty()) {
            return calculateRanks();
        }
        return this.rankingMap;
    }

    private Map<Rank, Integer> calculateRanks() {
        for (int targetCount : this.winningStats) {
            countByCase(targetCount, rankingMap);
        }
        return rankingMap;
    }

    private void countByCase(int targetCount, Map<Rank, Integer> rankingMap) { // FIXME 메서드 분리
        Arrays.stream(Rank.values()).forEach(rank -> {
            if (rank.getCountsOfSameNumbers() == targetCount) {
                rankingMap.put(rank, rankingMap.getOrDefault(rank, 0) + 1);
            }
        });
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
