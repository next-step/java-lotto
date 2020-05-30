package com.lotto.domain;

import java.util.Arrays;

public enum LottoWinningType {


    FIRST_CLASS(6, 2000000000L, Boolean.TRUE, "6개 일치 (2000000000원)- "),
    BONUS_BALL_CLASS(5, 30000000L, Boolean.FALSE, "5개 일치, 보너스 볼 일치(30000000원) - "),
    SECOND_CLASS(5, 1500000L, Boolean.TRUE, "5개 일치 (1500000원)- "),
    THIRD_CLASS(4, 50000L, Boolean.TRUE, "4개 일치 (50000원)- "),
    FORTH_CLASS(3, 5000L, Boolean.TRUE, "3개 일치 (5000원)- "),
    NOTHING_CLASS(0, 0L, Boolean.FALSE, "");

    private static final Integer CONDITION_OF_BONUS_BALL_DEFAULT_MATCHING_COUNT = 5;
    private static final Integer CONDITION_OF_BONUS_BALL_MATCHING_COUNT = 1;

    private Integer matchingCount;
    private Long winningAmount;
    private Boolean isDefaultClass;
    private String message;


    LottoWinningType(Integer matchingCount, Long winningAmount, Boolean isDefaultClass, String message) {
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
        this.isDefaultClass = isDefaultClass;
        this.message = message;
    }

    public Integer getMatchingCount() {
        return matchingCount;
    }

    public Long getWinningAmount() {
        return winningAmount;
    }

    public Boolean getDefaultClass() {
        return isDefaultClass;
    }

    public String getMessage() {
        return message;
    }

    public static LottoWinningType getLottoWinningType(Integer matchingCount, Integer bonusMatchingCount) {

        if (isBonusBallClass(matchingCount, bonusMatchingCount)) {
            return BONUS_BALL_CLASS;
        }

        return Arrays.stream(LottoWinningType.values())
                .filter(LottoWinningType::getDefaultClass)
                .filter(lottoWinningType -> {
                    Integer count = lottoWinningType.getMatchingCount();
                    return count.equals(matchingCount);
                })
                .findFirst()
                .orElse(NOTHING_CLASS);


    }

    private static Boolean isBonusBallClass(Integer matchingCount, Integer bonusMatchingCount) {
        return matchingCount.equals(CONDITION_OF_BONUS_BALL_DEFAULT_MATCHING_COUNT) && bonusMatchingCount.equals(CONDITION_OF_BONUS_BALL_MATCHING_COUNT);
    }
}
