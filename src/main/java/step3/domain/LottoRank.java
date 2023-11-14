package step3.domain;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int winningMoney;

    private LottoRank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.matchCount == matchCount) {
                return lottoRank;
            }
        }
        return MISS;
    }
}
