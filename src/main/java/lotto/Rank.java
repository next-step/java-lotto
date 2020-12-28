package lotto;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final boolean DEFAULT_MATCH_BONUS = false;

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean matchBonus;

    Rank(int countOfMatch, int winningMoney) {
        this(countOfMatch, winningMoney, DEFAULT_MATCH_BONUS);
    }

    Rank(int countOfMatch, int winningMoney, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        validate(countOfMatch);

        Stream<Rank> stream = Arrays.stream(values());
        return stream.filter(rank -> rank.equalsMatchCount(countOfMatch))
                     .filter(rank -> rank.isMatchBonus(matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private static void validate(int countOfMatch) {
        if (countOfMatch < 0) {
            throw new IllegalArgumentException("맞춘 개수는 0보다 작을 수 없습니다.");
        }

        if (countOfMatch > 6) {
            throw new IllegalArgumentException("맞춘 개수는 6보다 클 수 없습니다.");
        }
    }

    public boolean equalsMatchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    private boolean isMatchBonus(boolean matchBonus) {
        return this.matchBonus == matchBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}