/*
 * 당첨 가격과 당첨 개수에 따른 당첨금액을 계산하는 클래스
 * */
package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NO_MATCH(0, 0L),
    THREE_MATCH(3, 5000L),
    FOUR_MATCH(4, 50_000L),
    FIVE_MATCH(5, 1_500_000L),
    SIX_MATCH(6, 2_000_000_000L);

    public static final int LOTTO_PRICE = 1000;

    private final int matchNo;
    private final Long winningMoney;

    Rank(int matchNo, Long winningMoney) {
        this.matchNo = matchNo;
        this.winningMoney = winningMoney;
    }

    public Long getWinningMoney() {
        return winningMoney;
    }

    public static Rank matchRank(int matchNum) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchNo == matchNum)
                .findFirst()
                .orElse(NO_MATCH);
    }

}
