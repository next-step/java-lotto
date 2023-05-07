package step2.domain;

import java.util.List;

public class LottoMatches {
    public static final int MIN_MATCH_COUNT = 3;

    private LottoMatches() {
    }

    public static int[] getMatchCounts(List<List<Integer>> lottos, List<Integer> winningNumbers) {
        int[] matchCounts = {0, 0, 0, 0};
        lottos.stream()
                .mapToInt(lotto -> countMatchedNumbers(lotto, winningNumbers))
                .filter(matchedCount -> matchedCount >= MIN_MATCH_COUNT && matchedCount <= 6)
                .forEach(matchedCount -> matchCounts[matchedCount - MIN_MATCH_COUNT]++);
        return matchCounts;
    }

    public static int countMatchedNumbers(List<Integer> numbersToMatch, List<Integer> numbersToCompare) {
        return (int) numbersToMatch.stream()
                .filter(numbersToCompare::contains)
                .count();
    }
}
