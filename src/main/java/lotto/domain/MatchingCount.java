package lotto.domain;

import java.util.Objects;

public class MatchingCount {
    private final int countOfMatch;
    private final boolean hasBonusNumber;

    public MatchingCount(final int countOfMatch, final Boolean hasBonusNumber) {
        this.countOfMatch = countOfMatch;
        this.hasBonusNumber = hasBonusNumber;
    }
    
    public boolean is(int countOfMatch, boolean needBonusNumber) {
        if (needBonusNumber) {
            return countOfMatch == this.countOfMatch && hasBonusNumber;
        }
        return is(countOfMatch);
    }

    public boolean is(int countOfMatch) {
        if (hasBonusNumber) {
            return countOfMatch == this.countOfMatch - 1;
        }
        return this.countOfMatch == countOfMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        MatchingCount count = (MatchingCount) o;
        return countOfMatch == count.countOfMatch && hasBonusNumber == count.hasBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfMatch, hasBonusNumber);
    }
}
