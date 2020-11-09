package step2.domain.lotto;

import step2.type.WinningType;

import static step2.Constant.WINNING_NUMBER_ZERO;

public class WinningMatchCount {
    private int matchCount;

    public WinningMatchCount() {
        this(WINNING_NUMBER_ZERO);
    }

    public WinningMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void match(MarkingNumbers markingNumber, Integer number) {
        if (markingNumber.contains(number)) {
            plusCount();
        }
    }

    public WinningType getWinningType() {
        return WinningType.getType(matchCount);
    }


    private void plusCount() {
        matchCount++;
    }

    public void clear() {
        matchCount = WINNING_NUMBER_ZERO;
    }
}
