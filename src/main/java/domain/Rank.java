package domain;

public enum Rank {

    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    private final long matchLottoNumber;
    private final boolean containsBonus;
    private final long prize;

    Rank(final long matchLottoNumber, final boolean containsBonus, final long prize) {
        this.matchLottoNumber = matchLottoNumber;
        this.containsBonus = containsBonus;
        this.prize = prize;
    }

    public static Rank from(final long matchLottoNumber, final boolean containsBonus) {
        if (matchLottoNumber == FIRST.matchLottoNumber) {
            return FIRST;
        }
        if (matchLottoNumber == SECOND.matchLottoNumber && containsBonus) {
            return SECOND;
        }
        if (matchLottoNumber == THIRD.matchLottoNumber) {
            return THIRD;
        }
        if (matchLottoNumber == FOURTH.matchLottoNumber) {
            return FOURTH;
        }
        if (matchLottoNumber == FIFTH.matchLottoNumber) {
            return FIFTH;
        }
        return NONE;
    }

    public long getMatchLottoNumber() {
        return matchLottoNumber;
    }

    public boolean containsBonus() {
        return containsBonus;
    }

    public long getPrize() {
        return prize;
    }
}
