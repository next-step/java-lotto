package lotto.domain;

import java.util.Objects;

public class WinningResult {
    private final int correctCount;
    private final boolean bonus;

    public WinningResult(int correctNums) {
        this(correctNums, false);
    }

    public WinningResult(int correctCount, boolean bonus) {
        this.correctCount = correctCount;
        this.bonus = bonus;
    }

    public boolean hasSameCorrectCount(int count) {
        return  this.correctCount == count;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningResult that = (WinningResult) o;
        return correctCount == that.correctCount && bonus == that.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctCount, bonus);
    }
}
