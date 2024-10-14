package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private static final List<Integer> MATCHING_COUNT_FOR_WINNING = Arrays.asList(3, 4, 5, 6);

    private int matchCount;

    public int getMatchCount() {
        return this.matchCount;
    }

    public int calculateMatchCount(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            this.matchCount += checkMatchNumber(winningNumbers, lottoNumbers.get(i));
        }
        return this.matchCount;
    }

    private int checkMatchNumber(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean isWinningLotto() {
        return MATCHING_COUNT_FOR_WINNING.contains(this.matchCount);
    }

    public int getAmountForWinningLotto() {
        if (!isWinningLotto()) {
            return 0;
        }
        return determineAmountByMatchCount(this.matchCount);
    }

    public static int determineAmountByMatchCount(int matchCount) {
        if (matchCount == 3) {
            return 5000;
        } else if (matchCount == 4) {
            return 50000;
        } else if (matchCount == 5) {
            return 1500000;
        } else if (matchCount == 6) {
            return 2000000000;
        }
        return 0;
    }

}
