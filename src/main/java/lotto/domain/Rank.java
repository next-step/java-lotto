package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (matchBonus && (countOfMatch == Rank.SECOND.getCountOfMatch())) {
            return Rank.SECOND;
        }
        if (!matchBonus && (countOfMatch == Rank.THIRD.getCountOfMatch())) {
            return  Rank.THIRD;
        }
        Optional<Rank> result = Arrays.stream(Rank.values())
                .filter(rank -> rank.getCountOfMatch() == countOfMatch).findFirst();

        if (result.isPresent()) {
            return result.get();
        }
        return Rank.NONE;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "countOfMatch=" + countOfMatch +
                ", winningMoney=" + winningMoney +
                '}';
    }
}
