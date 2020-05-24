package com.lotto.domain;

public enum LottoWinningType {
    FIRST_CLASS(6, 5000L),
    SCOND_CLASS(5, 50000L),
    THIRD_CLASS(4, 1500000L),
    FORTH_CLASS(3, 2000000000L);

    private Integer matchingCount;
    private Long winningAmount;

    LottoWinningType(Integer matchingCount, Long winningAmount) {
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
    }


}
