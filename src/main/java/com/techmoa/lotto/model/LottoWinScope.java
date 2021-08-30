package com.techmoa.lotto.model;

public enum LottoWinScope {

    FOUR_PLACE(3, "3개 일치 (5000원)", 5_000),
    THREE_PLACE(4, "4개 일치 (50000원)", 50_000),
    TWO_PLACE(5, "5개 일치 (1500000원)", 1_500_000),
    FIRST(6, "6개 일치 (2000000000원)",2_000_000_000),

    ;

    private final int sameCount;
    private final String sameCountString;
    private final int winMoney;

    LottoWinScope(int sameCount, String sameCountString, int winMoney) {
        this.sameCount = sameCount;
        this.sameCountString = sameCountString;
        this.winMoney = winMoney;
    }

    public int getSameCount() {
        return sameCount;
    }

    public String getSameCountString() {
        return sameCountString;
    }

    public int getWinMoney() {
        return winMoney;
    }

}
