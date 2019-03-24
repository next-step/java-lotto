package lotto.domain;

public enum LottoRank{
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public static final int MATCH_COUNT_FIVE = 5;

    public final int number;
    public final long money;

    LottoRank(int number, long money) {
        this.number = number;
        this.money = money;
    }



    public static LottoRank valueOf(int number, boolean matchBonus) {
        if (number == MATCH_COUNT_FIVE) {
            return checkBonusRank(matchBonus);
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (checkRank(number, lottoRank)) {
                return lottoRank;
            }
        }
        return MISS;
    }

    private static boolean checkRank(int number, LottoRank lottoRank) {
        if (lottoRank.number == number) {
            return true;
        }
        return false;
    }

    private static LottoRank checkBonusRank(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
