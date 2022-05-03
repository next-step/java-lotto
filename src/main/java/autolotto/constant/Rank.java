package autolotto.constant;

import java.util.EnumSet;
import java.util.Optional;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    private static EnumSet<Rank> EXCEPT_FOR_SECOND = EnumSet.of(
            FIRST, THIRD, FOURTH, FIFTH
    );

    public static Optional<Rank> find(int countOfMatch, boolean hasBonusBall) {
        if (hasBonusBall) {
            return Optional.of(SECOND);
        }
        return EXCEPT_FOR_SECOND.stream()
                .filter(rank -> rank.getCountOfMatch() == countOfMatch)
                .findFirst();
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
