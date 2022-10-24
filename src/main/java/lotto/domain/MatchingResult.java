package lotto.domain;

import java.util.Objects;

public class MatchingResult {

    private final int countOfMatchedNumber;
    private final boolean isContainedBonus;

    public MatchingResult(final int countOfMatchedNumber, final boolean isContainedBonus) {
        this.countOfMatchedNumber = countOfMatchedNumber;
        this.isContainedBonus = isContainedBonus;
    }

    public int getCountOfMatchedNumber() {
        return countOfMatchedNumber;
    }

    public boolean isContainedBonus() {
        return isContainedBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof MatchingResult)) {
            return false;
        }

        MatchingResult that = (MatchingResult) o;

        if (this.countOfMatchedNumber != that.countOfMatchedNumber) {
            return false;
        }

        return this.isContainedBonus == that.isContainedBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfMatchedNumber, isContainedBonus);
    }
}
