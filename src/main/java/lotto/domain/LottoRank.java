package lotto.domain;

public enum LottoRank{
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public static final int MATCH_COUNT_FIVE = 5;

    public final int matchCount;
    public final long money;

    LottoRank(int matchCount, long money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == MATCH_COUNT_FIVE) {
            return checkBonusRank(matchBonus);
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (checkRank(matchCount, lottoRank)) {
                return lottoRank;
            }
        }
        return MISS;
    }

    private static boolean checkRank(int number, LottoRank lottoRank) {
        return lottoRank.matchCount == number;
    }

    private static LottoRank checkBonusRank(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
