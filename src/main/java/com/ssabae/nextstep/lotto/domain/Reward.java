package com.ssabae.nextstep.lotto.domain;

import java.util.Arrays;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public enum Reward {

    NONE  (0, Money.won(0L), false),
    FOURTH(3, Money.won(5_000L), true),
    THIRD (4, Money.won(50_000L), true),
    SECOND(5, Money.won(1_500_000L), true),
    FIRST (6, Money.won(2_000_000_000L), true);

    private final int countOfMatch;
    private final Money winningMoney;
    private final boolean report;

    Reward(int countOfMatch, Money winningMoney, boolean report) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.report = report;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public boolean isReport() {
        return report;
    }

    public static Money getWinningMoneyByMatchCount(int countOfMatch) {
        return Arrays.stream(values())
                .filter(reward -> reward.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(NONE)
                .winningMoney;
    }

    public static Reward[] getReportableRewards() {
        return Arrays.stream(values())
                .filter(Reward::isReport)
                .toArray(Reward[]::new);
    }



}
