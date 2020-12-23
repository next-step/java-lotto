package com.ssabae.nextstep.lotto.domain;

import java.util.Arrays;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public enum Reward {

    FIRST (6, false, true,  Money.won(2_000_000_000L)),
    SECOND(5, true,  true,  Money.won(30_000_000L)),
    THIRD (5, false, true,  Money.won(1_500_000L)),
    FOURTH(4, false, true,  Money.won(50_000L)),
    FIFTH (3, false, true,  Money.won(5_000L)),
    NONE  (0, false, false, Money.won(0L));

    private final int countOfMatch;
    private final boolean conditionOfMatchBonus;
    private final Money winningMoney;
    private final boolean report;

    Reward(int countOfMatch, boolean conditionOfMatchBonus, boolean report, Money winningMoney) {
        this.countOfMatch = countOfMatch;
        this.conditionOfMatchBonus = conditionOfMatchBonus;
        this.report = report;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public boolean isConditionOfMatchBonus() {
        return conditionOfMatchBonus;
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

    public static Reward matchingToReward(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(reward -> match(reward, matchCount, matchBonus))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean match(Reward reward, int matchCount, boolean matchBonus) {
        if (reward.conditionOfMatchBonus) {
            return (reward.countOfMatch == matchCount)
                    && (reward.conditionOfMatchBonus == matchBonus);
        }
        return reward.countOfMatch == matchCount;
    }
}
