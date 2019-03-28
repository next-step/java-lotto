package domain;

public enum LottoProfit {

    MISS(0,0),
    FIFTH(3,5_000),
    FOURTH(4,50_000),
    THIRD(5,1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6,2_000_000_000);

    private int numberOfMatch;
    private int prizeMoney;

    LottoProfit(int numberOfMatch, int prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public static LottoProfit valueOf(int numberOfMatch, boolean matchBonusNo) {
        //TODO 일치하는 수 -> 로또 등수로 변경
        return null;
    }

}
