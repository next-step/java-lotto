package step4;

import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public enum Rank{
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private int countOfMatch;
    private int winningMoney;
    private boolean matchedBonus;

    private Rank(int countOfMatch, int winningMoney, boolean matchedBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchedBonus = matchedBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isMatchedBonus() {
        return matchedBonus;
    }

    public static Rank rank(int countOfMatch, boolean matchedBonus) {
        Rank[] rank = values();

        return Stream.of(rank)
                .filter(ranks -> ranks.getCountOfMatch() == countOfMatch && ranks.isMatchedBonus() == matchedBonus)
                .findFirst()
                .orElse(Rank.MISS);
    }
}