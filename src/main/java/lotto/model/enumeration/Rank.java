package lotto.model.enumeration;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5.5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final Map<Double, Rank> RANK_MAP = Arrays.stream(Rank.values())
            .collect(Collectors.toMap(rank -> rank.countOfMatch, Function.identity()));

    private final double countOfMatch;
    private final int winningMoney;

    Rank(double countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public double getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(double countOfMatch, boolean isContainBonusBall) {
        return Optional.ofNullable(RANK_MAP.get(countOfMatch))
                .map(rank -> rank.getContainBonusBallRank(isContainBonusBall))
                .orElse(MISS);
    }

    private Rank getContainBonusBallRank(boolean isMatchBonusBall) {
        if (isMatchBonusBall && this.equals(THIRD)) {
            return SECOND;
        }

        return this;
    }
}