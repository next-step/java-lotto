package lotto.domain;

import java.util.List;

public class RankingCalculator {
    public int calculate(List<Integer> lastWeekWinning, List<List<Integer>> lottos, int expect) {
        int result = 0;
        for (List<Integer> lotto : lottos) {
            int matchCount = checkLottoMatchCount(lastWeekWinning, lotto);
            result = increaseResultIfMatchCountSameWithExpect(expect, matchCount, result);
        }
        return result;
    }

    private int checkLottoMatchCount(List<Integer> lastWeekWinning, List<Integer> lotto) {
        int matchCount = 0;
        for (int element : lotto) {
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
