package step4;

import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public enum Rank implements Bonus{
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public Rank rank(int countOfMatch, boolean bonusMatch) {
        Rank[] rank = values();

        if (Rank.SECOND.getCountOfMatch() == countOfMatch) {
            return bonus(bonusMatch);
        }

        return Stream.of(rank)
                .filter(ranks -> ranks.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);
    }
    
    @Override
    public Rank bonus(boolean bonusMatch) {
        if (bonusMatch) {
            return SECOND;
        }
        return THIRD;
    }
}