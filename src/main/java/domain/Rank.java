package domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    private final long matchLottoNumber;
    private final boolean hasToCheckBonus;
    private final Money prize;

    Rank(final long matchLottoNumber, final boolean hasToCheckBonus, final long prize) {
        this.matchLottoNumber = matchLottoNumber;
        this.hasToCheckBonus = hasToCheckBonus;
        this.prize = new Money(prize);
    }

    public static Rank from(final long matchLottoNumber, final boolean containsBonus) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.matchLottoNumber == matchLottoNumber
                && (rank.hasToCheckBonus ? containsBonus : true))
            .findFirst()
            .orElse(Rank.NONE);
    }

    public long getMatchLottoNumber() {
        return matchLottoNumber;
    }

    public boolean hasToCheckBonus() {
        return hasToCheckBonus;
    }

    public Money getPrize() {
        return prize;
    }
}
