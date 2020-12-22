package step4.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0, "꽝"),
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private int countOfMatch;
    private int winningMoney;
    private String message;

    Rank(int countOfMatch, int winningMoney, String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMessage() {
        return message;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (SECOND.countOfMatch == countOfMatch) {
            return secondAndThird(matchBonus);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.isMatchCount(countOfMatch))
                .findFirst()
                .orElse(MISS);
    }

    private static Rank secondAndThird(boolean matchBonus) {
        if (matchBonus){
            return SECOND;
        }
        return THIRD;
    }

    private boolean isMatchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}
