package lotto.domain;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND_BONUS(5, 30_000_000, true),
    SECOND(5, 1_500_000, false),
    THIRD(4, 50_000, false),
    FOURTH(3, 5_000, false),
    NONE(0, 0, false);


    private final int matchCount;
    private final int prize;
    private final boolean requireBonus;

    LottoRank(int matchCount, int prize, boolean requireBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requireBonus = requireBonus;
    }

    public static LottoRank of(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : LottoRank.values()) {
            if (isMatch(rank, matchCount, bonusMatch)) {
                return rank;
            }
        }

        return NONE;
    }

    public static boolean isMatch(LottoRank rank, int matchCount, boolean requireBonus) {
        return isCountMatch(rank, matchCount) && isBonusRequireMatch(rank, requireBonus);
    }

    private static boolean isCountMatch(LottoRank rank, int matchCount) {
        return rank.matchCount == matchCount;
    }

    private static boolean isBonusRequireMatch(LottoRank rank, boolean requireBonus) {
        return rank.requireBonus == requireBonus;
    }

    public int getPrize(LottoRank rank, int count) {
        return rank.prize * count;
    }

    @Override
    public String toString() {
        return String.format("%d개%s(%d원)", matchCount, matchString(), prize);
    }

    private String matchString() {
        return requireBonus ? ", 보너스 볼 일치" : " 일치";
    }
}
