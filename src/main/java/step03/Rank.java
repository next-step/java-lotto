package step03;

import java.util.stream.Stream;

public enum Rank {
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

    public static Stream<Rank> stream () {
        return Stream.of(FIRST, SECOND, THIRD, FOURTH, FIFTH);
    }

    public static Rank valueOf (int countOfMatch, boolean matchBonus) {
        return stream().filter(rank -> rank.getCountOfMatch() == countOfMatch)
                .filter(rank -> !rank.equals(SECOND) || matchBonus)
                .findAny().orElse(MISS);
    }

}
