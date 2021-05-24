package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WinningCounts {
    public static final int WINNING_NUMBER_MINIMUM = 3;
    public static final int WINNING_NUMBER_MAXIMUM = 6;
    private static final int DEFAULT_COUNT = 0;
    private final Map<Integer, Integer> winningMatchedCounts;

    public WinningCounts(Map<Integer, Integer> winningMatchedCounts) {
        validateMatchingNumber(winningMatchedCounts);
        this.winningMatchedCounts = new HashMap<>(winningMatchedCounts);
    }

    public boolean isEmpty() {
        return this.winningMatchedCounts.isEmpty();
    }

    public int getWinningCount(int winningMatchedNumber) {
        return this.winningMatchedCounts.getOrDefault(winningMatchedNumber, DEFAULT_COUNT);
    }

    public Set<Integer> getWinningNumberSet() {
        return this.winningMatchedCounts.keySet();
    }

    private void validateMatchingNumber(Map<Integer, Integer> winningMatchedCounts) {
        boolean error = false;
        for (Integer winningNumber : winningMatchedCounts.keySet()) {
            error |= winningNumber < WINNING_NUMBER_MINIMUM
                    || winningNumber > WINNING_NUMBER_MAXIMUM;
        }
        if (error) {
            throw new IllegalArgumentException("당첨을 인정하는 번호 일치 개수는 3~6개 입니다.");
        }
    }
}
