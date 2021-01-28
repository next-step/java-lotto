package lotto.domain;

public enum Prize {
    //    3개 일치 (5000원)- 1개
    //4개 일치 (50000원)- 0개
    //5개 일치 (1500000원)- 0개
    //5개 일치, 보너스 볼 일치(30000000원) - 0개
    //6개 일치 (2000000000원)- 0개

    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6,2000000000);

    private final int matchedNumber;
    private final int cash;

    Prize(final int matchedNumber, final int cash) {
        this.matchedNumber = matchedNumber;
        this.cash = cash;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "matchedNumber=" + matchedNumber +
                ", cash=" + cash +
                '}';
    }


}
