package com.ssabae.nextstep.lotto.domain;

import java.util.Arrays;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public enum Reward {

    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L),
    NONE(0, 0L);

    private final int countOfMatch;
    private final long winningMoney;

    Reward(int countOfMatch, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public static Money getWinningMoneyByMatchCount(int countOfMatch) {
        long winningMoney = Arrays.stream(values())
                .filter(reward -> reward.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(NONE)
                .winningMoney;
        return Money.won(winningMoney);
    }


}
