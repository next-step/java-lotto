package lotto.backend.domain;

import java.util.Objects;

public class Matching {

    private final int countOfMatch;
    private final boolean hasBonusNumber;

    public Matching(int countOfMatch, boolean hasBonusNumber) {
        this.countOfMatch = countOfMatch;
        this.hasBonusNumber = hasBonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matching matching = (Matching) o;
        return countOfMatch == matching.countOfMatch &&
                hasBonusNumber == matching.hasBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfMatch, hasBonusNumber);
    }
}
