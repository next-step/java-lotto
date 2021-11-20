package com.kakao.lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    OUT(0, 0);

    private final int correctRank;
    private final int price;

    LottoRank(int correctRank, int price) {
        this.correctRank = correctRank;
        this.price = price;
    }

    public static LottoRank findByMatchRank(int correctAmount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.correctRank == correctAmount)
                .findAny()
                .orElse(OUT);
    }

    public int getPrice() {
        return price;
    }

    public int getCorrectRank() {
        return correctRank;
    }

}
