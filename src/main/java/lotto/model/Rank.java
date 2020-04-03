package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    BLANK(0, 0, false);

    private static final int MONEY_TO_BUY_ONE_LOTTO = 1000;
    private static final int NO_INPUT = 0;

    private int matchCount;
    private int winningMoney;
    private boolean hasBonusBall;

    Rank(int matchCount, int winningMoney, boolean hasBonusBall) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.hasBonusBall = hasBonusBall;
    }

    public static Rank getMatchResult(int matchCount, boolean hasBonusBall) {
        return Arrays.stream(values())
                .filter(it -> it.hasBonusBall == hasBonusBall)
                .filter(it -> it.matchCount == matchCount)
                .findFirst()
                .orElse(BLANK);
    }

    public static int getAllPrizeMoney(List<Rank> ranks) {
        return ranks.stream()
                .map(it -> it.getWinningMoney())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static double findEarningRate(List<Rank> ranks) {
        double allPrizeMoney = getAllPrizeMoney(ranks);
        int inputMoney = ranks.size() * MONEY_TO_BUY_ONE_LOTTO;

        if (ranks.size() == NO_INPUT) {
            return 0;
        }

        return (allPrizeMoney / inputMoney) * 100;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}