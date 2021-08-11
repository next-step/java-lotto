package lotto.domain;

import lotto.common.LottoResult;

import java.util.List;

public class RankingCalculator {
    public LottoResult calculate(List<Integer> lastWeekWinning, Lottos lottos, int expect) {
        int hits = 0;
        for (Lotto lotto : lottos.getElements()) {
            int matchCount = checkLottoMatchCount(lastWeekWinning, lotto);
            hits = increaseResultIfMatchCountSameWithExpect(expect, matchCount, hits);
        }
        return new LottoResult(expect, hits);
    }

    private int checkLottoMatchCount(List<Integer> lastWeekWinning, Lotto lotto) {
        int matchCount = 0;
        for (int element : lotto.getElements()) {
            matchCount = increaseIfLastWeekWinningContainsElement(lastWeekWinning, element, matchCount);
        }
        return matchCount;
    }

    private int increaseIfLastWeekWinningContainsElement(List<Integer> lastWeekWinningElements,
                                                         int element, int matchCount) {
        if (lastWeekWinningElements.contains(element)) {
            return matchCount + 1;
        }
        return matchCount;
    }

    private int increaseResultIfMatchCountSameWithExpect(int expect, int matchCount, int result) {
        if (matchCount == expect) {
            return result + 1;
        }
        return result;
    }
}
