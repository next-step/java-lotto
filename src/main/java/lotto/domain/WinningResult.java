package lotto.domain;

import java.util.Objects;

public class WinningResult{
    private Prize prize;
    private int matchCount;

    public WinningResult(Prize prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResult that = (WinningResult) o;
        return matchCount == that.matchCount &&
                prize == that.prize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize, matchCount);
    }

    @Override
    public String toString() {
        return "WinningResult{" +
                "prize=" + prize +
                ", matchCount=" + matchCount +
                '}';
    }
}