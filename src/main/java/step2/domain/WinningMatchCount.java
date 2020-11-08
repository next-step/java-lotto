package step2.domain;

import java.util.List;

import static step2.Constant.WINNING_NUMBER_ZERO;

public class WinningMatchCount {
    private int matchCount;

    public WinningMatchCount() {
        this(WINNING_NUMBER_ZERO);
    }

    public WinningMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public void match(MarkingNumbers markingNumber, Integer number) {
        if (markingNumber.contains(number)) {
            plusCount();
        }
    }

    private void plusCount() {
        matchCount++;
    }
}
