package step3.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0, false, "꽝"),
    FIFTH(3, 5_000, false, "3개 일치"),
    FOURTH(4, 50_000, false, "4개 일치"),
    THIRD(5, 1_500_000, false, "5개 일치"),
    SECOND(5, 30_000_000, true, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, false, "6개 일치");


    private int countOfMatch;
    private int winningMoney;
    private boolean bonus;
    private String message;

    Rank(int countOfMatch, int winningMoney, boolean bonus, String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonus = bonus;
        this.message = message;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean getBonus() {return bonus;}

    public String getMessage() {
        return message;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatchCount(countOfMatch, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private boolean isMatchCount(int countOfMatch, boolean matchBonus) {
        return this.countOfMatch == countOfMatch && this.bonus == matchBonus;
    }
}
