package domain;

public enum LottoProfit {

    fourth(3,5000),
    third(4,50000),
    second(5,1500000),
    first(6,2000000000);

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

}
