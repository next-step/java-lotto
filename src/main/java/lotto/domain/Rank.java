/*
 * 당첨 가격과 당첨 개수에 따른 당첨금액을 계산하는 클래스
 * */
package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    public static final int LOTTO_PRICE = 1000;

    private final int matchNo;
    private final Long winningMoney;

    Rank(int matchNo, Long winningMoney) {
        this.matchNo = matchNo;
        this.winningMoney = winningMoney;
    }

    public int getMatchNo() {
        return matchNo;
    }

    public Long getWinningMoney() {
        return winningMoney;
    }

    public static Rank matchRank(int matchNum, boolean Bonus) {
        if (matchNum == SECOND.matchNo && Bonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchNo == matchNum)
                .findFirst()
                .orElse(MISS);
    }

}
