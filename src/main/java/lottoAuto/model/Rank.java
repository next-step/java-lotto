package lottoAuto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FORTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NO_MATCH(0, 0, false);

    private int matchWinning;
    private int prize;
    private boolean isBonus;

    Rank(int matchWinning, int prize, boolean isBonus) {
        this.matchWinning = matchWinning;
        this.prize = prize;
        this.isBonus = isBonus;
    }

    public static Rank findByRank(int winningCount, Boolean hasBonus) {
        if (winningCount == 5 && hasBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchWinning == winningCount && !rank.isBonus)
                .findAny()
                .orElse(NO_MATCH);
    }

}
