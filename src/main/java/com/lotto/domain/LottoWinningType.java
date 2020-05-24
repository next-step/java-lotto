package com.lotto.domain;

import java.util.Arrays;

public enum LottoWinningType {

    FIRST_CLASS(6, 2000000000L),
    SECOND_CLASS(5, 1500000L),
    THIRD_CLASS(4, 50000L),
    FORTH_CLASS(3, 5000L),
    NOTHING_CLASS(null, 0L);

    private Integer matchingCount;
    private Long winningAmount;

    LottoWinningType(Integer matchingCount, Long winningAmount) {
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
    }

    public Integer getMatchingCount() {
        return matchingCount;
    }

    public Long getWinningAmount() {
        return winningAmount;
    }

    public static LottoWinningType getLottoWinningType(Integer matchingCount) {

        return Arrays.stream(LottoWinningType.values())
                .filter(lottoWinningType -> {
                    Integer count = lottoWinningType.getMatchingCount();
                    return count != null && count.equals(matchingCount);
                })
                .findFirst()
                .orElse(NOTHING_CLASS);
    }
}
