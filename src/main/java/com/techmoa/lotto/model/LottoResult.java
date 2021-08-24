package com.techmoa.lotto.model;

public enum LottoResult {

    FIRST(6, "6개 일치", "2000000000원"),
    TWO_PLACE(5, "5개 일치", "1500000원"),
    THREE_PLACE(4, "4개 일치", "5000원"),
    FOUR_PLACE(3, "3개 일치", "5000원"),
    ;

    private int sameCount;
    private String sameCountString;
    private String containPrice;

    LottoResult(int sameCount, String sameCountString, String containPrice) {
        this.sameCount = sameCount;
        this.sameCountString = sameCountString;
        this.containPrice = containPrice;
    }

    public int getSameCount() {
        return sameCount;
    }

    public String getSameCountString() {
        return sameCountString;
    }

    public String getContainPrice() {
        return containPrice;
    }
}
