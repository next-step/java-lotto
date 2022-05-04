package domain;

public enum LottoRank {
    SIX_NUMBERS(6, 2000000000),
    FIVE_NUMBERS_AND_BONUS(5, 30000000),
    FIVE_NUMBERS(5, 1500000),
    FOUR_NUMBERS(4, 50000),
    THREE_NUMBERS(3, 5000);

    private final int lottoMatchCount;
    private final int lottoRankMoney;

    LottoRank(int lottoMatchCount, int lottoRankMoney) {
        this.lottoMatchCount = lottoMatchCount;
        this.lottoRankMoney = lottoRankMoney;
    }

    public static boolean checkBonusRank(LottoRank lottoRank) {
        return LottoRank.FIVE_NUMBERS_AND_BONUS == lottoRank;
    }

    public int getLottoRankMoney() {
        return lottoRankMoney;
    }

    public int getLottoMatchCount() {
        return lottoMatchCount;
    }
}
