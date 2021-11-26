package lotto.domain;

import java.util.Objects;

public class LottoMatch {
    private static final int SECOND_COUNT = 5;

    private final int matchCount;
    private final boolean matchBonus;

    private LottoMatch(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static LottoMatch of(int matchCount, boolean matchBonus) {
        return new LottoMatch(matchCount, matchBonus);
    }

    public int matchCount() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatch other = (LottoMatch) o;

        if (this.matchCount == SECOND_COUNT && other.matchCount == SECOND_COUNT) {
            return matchBonus == other.matchBonus;
        }

        return matchCount == other.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, matchBonus);
    }

}
