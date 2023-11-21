package lotto.model;

import java.util.Objects;

public class CorrectNumbers {
    private final int correctCount;
    private final boolean isMatch;

    public CorrectNumbers(int correctCount, boolean isMatch) {
        this.correctCount = correctCount;
        this.isMatch = isMatch;
    }

    public int correctCount() {
        return correctCount;
    }

    public boolean isMatchNumberAndBonus(int correctCount, boolean isMatch){
        return isMatchNormalCount(correctCount) && isMatch(isMatch);
    }

    public boolean isMatch(boolean isMatch) {
        return this.isMatch == isMatch;
    }

    public boolean isMatchNormalCount(int correctCount) {
        return correctCount == this.correctCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrectNumbers that = (CorrectNumbers) o;
        return correctCount == that.correctCount && isMatch == that.isMatch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctCount, isMatch);
    }
}
