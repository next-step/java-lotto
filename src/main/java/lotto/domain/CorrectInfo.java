package lotto.domain;

import java.util.List;
import java.util.Objects;

public class CorrectInfo {
    private int correctCount;
    boolean bonus;

    public CorrectInfo(int correctNums) {
        this(correctNums, false);
    }

    public CorrectInfo(int correctCount, boolean bonus) {
        this.correctCount = correctCount;
        this.bonus = bonus;
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
        CorrectInfo that = (CorrectInfo) o;
        return correctCount == that.correctCount && bonus == that.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctCount, bonus);
    }
}
