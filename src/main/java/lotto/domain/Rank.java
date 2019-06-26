package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
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

    public static Rank valueOf(int countOfMatch) {
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
