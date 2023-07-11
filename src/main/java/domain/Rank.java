package domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NONE(0, false);

    private final long matchLottoNumber;
    private final boolean hasToCheckBonus;

    Rank(final long matchLottoNumber, final boolean hasToCheckBonus) {
        this.matchLottoNumber = matchLottoNumber;
        this.hasToCheckBonus = hasToCheckBonus;
    }

    public static Rank resolveRank(final long matchLottoNumber, final boolean containsBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.match(matchLottoNumber, containsBonus))
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    private boolean match(final long matchLottoNumber, final boolean containsBonus) {
        if (this.matchLottoNumber > matchLottoNumber) {
            return false;
        }
        if (this.hasToCheckBonus) {
            return containsBonus;
        }
        return true;
    }
}
