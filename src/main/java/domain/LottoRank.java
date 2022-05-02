package domain;

public enum LottoRank {
    THREE_NUMBERS(3,5000),
    FOUR_NUMBERS(4,50000),
    FIVE_NUMBERS(5,1500000),
    FIVE_NUMBERS_AND_BONUS(5,30000000),
    SIX_NUMBERS(6,2000000000);


    private final int lottoRank;
    private final int lottoRankMoney;

    LottoRank(int lottoRank, int lottoRankMoney) {
        this.lottoRank = lottoRank;
        this.lottoRankMoney = lottoRankMoney;
    }

    public int getLottoRankMoney() {
        return lottoRankMoney;
    }

    public int getLottoRank() {
        return lottoRank;
    }
}
