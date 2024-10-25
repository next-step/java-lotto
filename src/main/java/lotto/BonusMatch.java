package lotto;

import java.util.Objects;

public class BonusMatch {
    private boolean isBonusMatch = false;

    public BonusMatch(boolean isBonusMatch) {
        this.isBonusMatch = isBonusMatch;
    }

    public boolean getIsBonusMatch() {
        return this.isBonusMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusMatch that = (BonusMatch) o;
        return isBonusMatch == that.isBonusMatch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBonusMatch);
    }
}
