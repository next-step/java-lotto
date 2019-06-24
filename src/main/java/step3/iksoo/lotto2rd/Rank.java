package step3.iksoo.lotto2rd;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, "1등"),
    SECOND(5, 30_000_000, "2등(보너스볼)"),
    THIRD(5, 1_500_000, "3등"),
    FOURTH(4, 50_000, "4등"),
    FIFTH(3, 5_000, "5등"),
    SIXTH(2, 0, ""),
    SEVENTH(1, 0, ""),
    EIGHTH(0, 0, "");

    private int countOfMatch;
    private int winningMoney;
    private String rankName;

    Rank(int countOfMatch, int winningMoney, String rankName) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.rankName = rankName;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public String getRankName() {
        return this.rankName;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        return Arrays.stream(ranks)
                .filter(n -> n.getCountOfMatch() == countOfMatch)
                .map(n -> {
                    if (n.getCountOfMatch() == THIRD.getCountOfMatch()) {
                        return matchBonus ? SECOND : THIRD;
                    }
                    return n;
                })
                .findAny()
                .orElse(null);
    }
}