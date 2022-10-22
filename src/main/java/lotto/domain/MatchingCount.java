package lotto.domain;

import java.util.Objects;

public class MatchingCount {
    private final int countOfMatch;
    private final Boolean hasBonusNumber;

    public MatchingCount(final int countOfMatch) {
        this(countOfMatch, null);
    }

    public MatchingCount(final int countOfMatch, final Boolean hasBonusNumber) {
        this.countOfMatch = countOfMatch;
        this.hasBonusNumber = hasBonusNumber;
    }
    
    public int getCountOfMatch() {
        return countOfMatch;
    }

    public Boolean hasBonusNumber() {
        if (hasBonusNumber == null) {
            return false;
        }
        return hasBonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        
        MatchingCount count = (MatchingCount) o;
        boolean equalsCountOfMatch = countOfMatch == count.countOfMatch;
        if (hasBonusNumber == null) {
            return equalsCountOfMatch;
        }
        return equalsCountOfMatch && hasBonusNumber == count.hasBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfMatch, hasBonusNumber);
    }
}
